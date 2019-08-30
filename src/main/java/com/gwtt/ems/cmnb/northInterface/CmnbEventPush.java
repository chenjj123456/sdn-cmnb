package com.gwtt.ems.cmnb.northInterface;

import com.gwtt.ems.cmnb.model.north.event.EventInQueque;
import com.gwtt.ems.cmnb.model.north.fault.AlarmList;
import com.gwtt.ems.cmnb.model.north.fault.Alarms;
import com.gwtt.ems.cmnb.model.north.fault.AlarmsNotification;
import com.gwtt.ems.cmnb.model.north.notification.Notification;
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
    private List<AlarmList> alarmPushList;
    //    private List<Ne> alarmPushList;
    private static CmnbEventPush instance;
    private EventInQueque event = null;

    private CmnbEventPush() {
        init();
        eventPushSchedule = Executors.newSingleThreadScheduledExecutor();
        alarmPushList = Collections.synchronizedList(new ArrayList<>());
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
                    break;
            }
        }
        if (alarmPushList.size()>0){
            pushAlarmData(alarmPushList);
            alarmPushList = Collections.synchronizedList(new ArrayList<>());
        }
    }

    private void pushAlarmData(List<AlarmList> alarmLists) {
        try {
            ListenerAdapter alarmListener = Notificator.getInstance().getListenerFor("alarms-notification");
            if (alarmListener != null) {
                Alarms alarms = new Alarms();
                alarms.setAlarmList(alarmLists);
                AlarmsNotification alarmsNotification = new AlarmsNotification();
                alarmsNotification.setAlarms(alarms);
                Notification notification = new Notification();
                notification.setEventTime(CmnbUtil.getDateAndTime(new Date()));
                notification.setAlarmsNotification(alarmsNotification);

                String alarmXml = JaxbObjectAndXmlUtil.object2xml(AlarmsNotification.class, alarmsNotification);
                alarmListener.sendEvent(alarmXml);
                CmnbLogger.CMNBOUT.log("AlarmObserver:push:admin" + alarmLists, 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            CmnbLogger.CMNBERR.logException(e, 3);
        }
    }

}
