package com.gwtt.ems.cmnb.northInterface;

import com.gwtt.ems.cmnb.model.common.UpdateType;
import com.gwtt.ems.cmnb.model.north.CmnbBaseData;
import com.gwtt.ems.cmnb.model.north.event.Adds;
import com.gwtt.ems.cmnb.model.north.event.Deletes;
import com.gwtt.ems.cmnb.model.north.event.EventInQueque;
import com.gwtt.ems.cmnb.model.north.event.Updates;
import com.gwtt.ems.cmnb.model.north.fault.AlarmList;
import com.gwtt.ems.cmnb.model.north.notification.*;
import com.gwtt.ems.cmnb.util.CmnbLogger;
import com.gwtt.ems.cmnb.util.CmnbUtil;
import com.gwtt.ems.cmnb.util.Constants;
import com.gwtt.ems.cmnb.util.JaxbObjectAndXmlUtil;
import com.gwtt.ems.cmnb.websocket.listener.ListenerAdapter;
import com.gwtt.ems.cmnb.websocket.listener.Notificator;
import com.gwtt.management.log.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by chenjj on 2019/8/29
 */
public class CmnbEventPush implements Runnable {
    private final ScheduledExecutorService eventPushSchedule;
    private static BlockingQueue<EventInQueque> eventQueue;
    //告警列表
    private List<AlarmList> alarmPushList;
    //网元列表
    private List<CmnbBaseData> addNePushList;
    private List<CmnbBaseData> updateNePushList;
    private List<String> deleteNePushList;

    //端口列表
    private List<CmnbBaseData> addLtpPushList;
    private List<CmnbBaseData> updateLtpPushList;
    private List<String> deleteLtpPushList;

    //TopoNode列表
    private List<CmnbBaseData> addNodePushList;
    private List<CmnbBaseData> updateNodePushList;
    private List<String> deleteNodePushList;
    
    //TopoLink列表
    private List<CmnbBaseData> addLinkPushList;
    private List<CmnbBaseData> updateLinkPushList;
    private List<String> deleteLinkPushList;

    private static CmnbEventPush instance;
    private EventInQueque event = null;

    private CmnbEventPush() {
        init();
        eventPushSchedule = Executors.newSingleThreadScheduledExecutor();

        alarmPushList = Collections.synchronizedList(new ArrayList<>());

        addNePushList = Collections.synchronizedList(new ArrayList<>());
        updateNePushList = Collections.synchronizedList(new ArrayList<>());
        deleteNePushList = Collections.synchronizedList(new ArrayList<>());

        addLtpPushList = Collections.synchronizedList(new ArrayList<>());
        updateLtpPushList = Collections.synchronizedList(new ArrayList<>());
        deleteLtpPushList = Collections.synchronizedList(new ArrayList<>());

        addNodePushList = Collections.synchronizedList(new ArrayList<>());
        updateNodePushList = Collections.synchronizedList(new ArrayList<>());
        deleteNodePushList = Collections.synchronizedList(new ArrayList<>());

        addLinkPushList = Collections.synchronizedList(new ArrayList<>());
        updateLinkPushList = Collections.synchronizedList(new ArrayList<>());
        deleteLinkPushList = Collections.synchronizedList(new ArrayList<>());
    }

    public static synchronized CmnbEventPush getInstance() {
        if (null == instance) {
            instance = new CmnbEventPush();
        }
        return instance;
    }

    private void init() {
        if (eventQueue == null) {
            eventQueue = new LinkedBlockingDeque<>();
        }
    }

    public void startSchedule() {
        eventPushSchedule.scheduleWithFixedDelay(this, 1000, 100, TimeUnit.MILLISECONDS);
    }

    public void stopSchedule() {
        eventPushSchedule.shutdown();

    }

    /**
     * @param event
     * @return
     * @descr 将事件放入队列中
     */
    public void addEvent(EventInQueque event) {
        try {
            eventQueue.put(event);
        } catch (InterruptedException e) {
            CmnbLogger.CMNBERR.log("the Queue is full,please wait", Log.VERBOSE);
            e.printStackTrace();
        }
    }

    /**
     * @param
     * @return event
     * @descr 从队列中取事件
     */
    public EventInQueque getEvent() {
        try {
            event = eventQueue.take();
        } catch (InterruptedException e) {
            CmnbLogger.CMNBERR.log("the queue is empty, please wait", Log.VERBOSE);
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public void run() {
        while (!eventQueue.isEmpty()) {
            EventInQueque event = getEvent();
            switch (event.getPushEventType()) {
                case Alarm:
                    alarmPushList.add((AlarmList) event.getPushEventData());
                    if (alarmPushList.size() == Constants.list_size) {
                        pushAlarmData(alarmPushList);
                        alarmPushList = Collections.synchronizedList(new ArrayList<>());
                    }
                    break;
                case Ne:
                    if (event.getEventUpdateType().equals(UpdateType.Add)) {
                        addNePushList.add(event.getPushEventData());
                    } else if (event.getEventUpdateType().equals(UpdateType.Update)) {
                        updateNePushList.add(event.getPushEventData());
                    } else {
                        deleteNePushList.add(event.getPushEventData().getId());
                    }

                    if (addNePushList.size() == Constants.list_size
                            || updateNePushList.size() == Constants.list_size
                            || deleteNePushList.size() == Constants.list_size) {
                        pushNeData(addNePushList, updateNePushList, deleteNePushList);
                        addNePushList = Collections.synchronizedList(new ArrayList<>());
                        updateNePushList = Collections.synchronizedList(new ArrayList<>());
                        deleteNePushList = Collections.synchronizedList(new ArrayList<>());
                    }
                    break;
                case Ltp:
                    if (event.getEventUpdateType().equals(UpdateType.Add)) {
                        addLtpPushList.add(event.getPushEventData());
                    } else if (event.getEventUpdateType().equals(UpdateType.Update)) {
                        updateLtpPushList.add(event.getPushEventData());
                    } else {
                        deleteLtpPushList.add(event.getPushEventData().getId());
                    }

                    if (addLtpPushList.size() == Constants.list_size
                            || updateLtpPushList.size() == Constants.list_size
                            || deleteLtpPushList.size() == Constants.list_size) {
                        pushLtpData(addLtpPushList, updateLtpPushList, deleteLtpPushList);
                        addLtpPushList = Collections.synchronizedList(new ArrayList<>());
                        updateLtpPushList = Collections.synchronizedList(new ArrayList<>());
                        deleteLtpPushList = Collections.synchronizedList(new ArrayList<>());
                    }
                    break;
                case TopoNode:
                    if (event.getEventUpdateType().equals(UpdateType.Add)) {
                        addNodePushList.add(event.getPushEventData());
                    } else if (event.getEventUpdateType().equals(UpdateType.Update)) {
                        updateNodePushList.add(event.getPushEventData());
                    } else {
                        deleteNodePushList.add(event.getPushEventData().getId());
                    }

                    if (addNodePushList.size() == Constants.list_size
                            || updateNodePushList.size() == Constants.list_size
                            || deleteNodePushList.size() == Constants.list_size) {
                        pushNodeData(addNodePushList, updateNodePushList, deleteNodePushList);
                        addNodePushList = Collections.synchronizedList(new ArrayList<>());
                        updateNodePushList = Collections.synchronizedList(new ArrayList<>());
                        deleteNodePushList = Collections.synchronizedList(new ArrayList<>());
                    }
                    break; 
                case TopoLink:
                    if (event.getEventUpdateType().equals(UpdateType.Add)) {
                        addLinkPushList.add(event.getPushEventData());
                    } else if (event.getEventUpdateType().equals(UpdateType.Update)) {
                        updateLinkPushList.add(event.getPushEventData());
                    } else {
                        deleteLinkPushList.add(event.getPushEventData().getId());
                    }

                    if (addLinkPushList.size() == Constants.list_size
                            || updateLinkPushList.size() == Constants.list_size
                            || deleteLinkPushList.size() == Constants.list_size) {
                        pushLinkData(addLinkPushList, updateLinkPushList, deleteLinkPushList);
                        addLinkPushList = Collections.synchronizedList(new ArrayList<>());
                        updateLinkPushList = Collections.synchronizedList(new ArrayList<>());
                        deleteLinkPushList = Collections.synchronizedList(new ArrayList<>());
                    }   
            }
        }
        if (alarmPushList.size() > 0) {
            pushAlarmData(alarmPushList);
            alarmPushList = Collections.synchronizedList(new ArrayList<>());
        }

        if (addNePushList.size() > 0
                || updateNePushList.size() > 0
                || deleteNePushList.size() > 0) {
            pushNeData(addNePushList, updateNePushList, deleteNePushList);
            addNePushList = Collections.synchronizedList(new ArrayList<>());
            updateNePushList = Collections.synchronizedList(new ArrayList<>());
            deleteNePushList = Collections.synchronizedList(new ArrayList<>());
        }

        if (addLtpPushList.size() > 0
                || updateLtpPushList.size() > 0
                || deleteLtpPushList.size() > 0) {
            pushLtpData(addLtpPushList, updateLtpPushList, deleteLtpPushList);
            addLtpPushList = Collections.synchronizedList(new ArrayList<>());
            updateLtpPushList = Collections.synchronizedList(new ArrayList<>());
            deleteLtpPushList = Collections.synchronizedList(new ArrayList<>());
        }

        if (addNodePushList.size() > 0
                || updateNodePushList.size() > 0
                || deleteNodePushList.size() > 0) {
            pushNodeData(addNodePushList, updateNodePushList, deleteNodePushList);
            addNodePushList = Collections.synchronizedList(new ArrayList<>());
            updateNodePushList = Collections.synchronizedList(new ArrayList<>());
            deleteNodePushList = Collections.synchronizedList(new ArrayList<>());
        }

        if (addLinkPushList.size() > 0
                || updateLinkPushList.size() > 0
                || deleteLinkPushList.size() > 0) {
            pushLinkData(addLinkPushList, updateLinkPushList, deleteLinkPushList);
            addLinkPushList = Collections.synchronizedList(new ArrayList<>());
            updateLinkPushList = Collections.synchronizedList(new ArrayList<>());
            deleteLinkPushList = Collections.synchronizedList(new ArrayList<>());
        }
    }

    private void pushAlarmData(List<AlarmList> alarmLists) {
        try {
            ListenerAdapter alarmListener = Notificator.getInstance().getListenerFor("alarms-notification");
            if (alarmListener != null) {
                AlarmsNotification alarmsNotification = new AlarmsNotification();
                alarmsNotification.setAlarmList(alarmLists);

                Notification notification = new Notification();
                notification.setEventTime(CmnbUtil.getDateAndTime(new Date()));
                notification.setAlarmsNotification(alarmsNotification);

                String alarmXml = JaxbObjectAndXmlUtil.object2xml(AlarmsNotification.class, alarmsNotification);
                alarmListener.sendEvent(alarmXml);
                CmnbLogger.CMNBOUT.log("AlarmObserver:push:admin" + alarmXml, 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            CmnbLogger.CMNBERR.logException(e, 3);
        }
    }

    private void pushNeData(List<CmnbBaseData> addNePushList, List<CmnbBaseData> updateNePushList, List<String> deleteNePushList) {
        try {
            ListenerAdapter neListener = Notificator.getInstance().getListenerFor("ne-notification");
            if (neListener != null) {
                Adds adds = new Adds();
                Updates updates = new Updates();
                Deletes deletes = new Deletes();
                adds.setAddList(addNePushList);
                updates.setUpdateList(updateNePushList);
                deletes.setDeleteList(deleteNePushList);

                NeNotification neNotification = new NeNotification();
                neNotification.setAdds(adds);
                neNotification.setUpdates(updates);
                neNotification.setDeletes(deletes);

                Notification notification = new Notification();
                notification.setEventTime(CmnbUtil.getDateAndTime(new Date()));
                notification.setNeNotification(neNotification);

                String neXml = JaxbObjectAndXmlUtil.object2xml(NeNotification.class, neNotification);
                neListener.sendEvent(neXml);
                CmnbLogger.CMNBOUT.log("neObserver:push:admin" + neXml, 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            CmnbLogger.CMNBERR.logException(e, 3);
        }

    }

    private void pushLtpData(List<CmnbBaseData> addLtpPushList, List<CmnbBaseData> updateLtpPushList, List<String> deleteLtpPushList) {
        try {
            ListenerAdapter ltpListener = Notificator.getInstance().getListenerFor("ltp-notification");
            if (ltpListener != null) {

                Adds adds = new Adds();
                Updates updates = new Updates();
                Deletes deletes = new Deletes();
                adds.setAddList(addLtpPushList);
                updates.setUpdateList(updateLtpPushList);
                deletes.setDeleteList(deleteLtpPushList);

                LtpNotification ltpNotification = new LtpNotification();
                ltpNotification.setAdds(adds);
                ltpNotification.setUpdates(updates);
                ltpNotification.setDeletes(deletes);

                Notification notification = new Notification();
                notification.setEventTime(CmnbUtil.getDateAndTime(new Date()));
                notification.setLtpNotification(ltpNotification);

                String ltpXml = JaxbObjectAndXmlUtil.object2xml(LtpNotification.class, ltpNotification);
                ltpListener.sendEvent(ltpXml);
                CmnbLogger.CMNBOUT.log("ltpObserver:push:admin" + ltpXml, 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            CmnbLogger.CMNBERR.logException(e, 3);
        }
    }


    private void pushNodeData(List<CmnbBaseData> addNodePushList, List<CmnbBaseData> updateNodePushList, List<String> deleteNodePushList) {
        try {
            ListenerAdapter ltpListener = Notificator.getInstance().getListenerFor("node-notification");
            if (ltpListener != null) {

                Adds adds = new Adds();
                Updates updates = new Updates();
                Deletes deletes = new Deletes();
                adds.setAddList(addNodePushList);
                updates.setUpdateList(updateNodePushList);
                deletes.setDeleteList(deleteNodePushList);

                NodeNotification nodeNotification = new NodeNotification();
                nodeNotification.setAdds(adds);
                nodeNotification.setUpdates(updates);
                nodeNotification.setDeletes(deletes);

                Notification notification = new Notification();
                notification.setEventTime(CmnbUtil.getDateAndTime(new Date()));
                notification.setNodeNotification(nodeNotification);

                String nodeXml = JaxbObjectAndXmlUtil.object2xml(NodeNotification.class, nodeNotification);
                ltpListener.sendEvent(nodeXml);
                CmnbLogger.CMNBOUT.log("nodeObserver:push:admin" + nodeXml, 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            CmnbLogger.CMNBERR.logException(e, 3);
        }
    }

    private void pushLinkData(List<CmnbBaseData> addLinkPushList, List<CmnbBaseData> updateLinkPushList, List<String> deleteLinkPushList) {
        try {
            ListenerAdapter ltpListener = Notificator.getInstance().getListenerFor("link-notification");
            if (ltpListener != null) {

                Adds adds = new Adds();
                Updates updates = new Updates();
                Deletes deletes = new Deletes();
                adds.setAddList(addLinkPushList);
                updates.setUpdateList(updateLinkPushList);
                deletes.setDeleteList(deleteLinkPushList);

                LinkNotification linkNotification = new LinkNotification();
                linkNotification.setAdds(adds);
                linkNotification.setUpdates(updates);
                linkNotification.setDeletes(deletes);

                Notification notification = new Notification();
                notification.setEventTime(CmnbUtil.getDateAndTime(new Date()));
                notification.setLinkNotification(linkNotification);

                String linkXml = JaxbObjectAndXmlUtil.object2xml(LinkNotification.class, linkNotification);
                ltpListener.sendEvent(linkXml);
                CmnbLogger.CMNBOUT.log("nodeObserver:push:admin" + linkXml, 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            CmnbLogger.CMNBERR.logException(e, 3);
        }
    }
}
