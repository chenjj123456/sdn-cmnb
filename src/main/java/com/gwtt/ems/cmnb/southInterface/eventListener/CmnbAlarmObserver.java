package com.gwtt.ems.cmnb.southInterface.eventListener;

import com.gwtt.ems.cmnb.model.north.event.EventInQueque;
import com.gwtt.ems.cmnb.model.north.event.PushEventType;
import com.gwtt.ems.cmnb.model.north.fault.AlarmList;
import com.gwtt.ems.cmnb.northInterface.CmnbEventPush;
import com.gwtt.ems.cmnb.util.CmnbUtil;
import com.gwtt.nms.faultd.Alarm;
import com.gwtt.nms.faultd.AlarmObserver;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by chenjj on 2019/7/26
 */
public class CmnbAlarmObserver implements AlarmObserver {

    private static CmnbAlarmObserver instance;

    public static synchronized CmnbAlarmObserver getInstance() {
        if (null == instance) {
            instance = new CmnbAlarmObserver();
        }
        return instance;
    }

    @Override
    public void update(Alarm alarm) throws RemoteException {
        //从nms监听到的告警添加到集合中
        AlarmList nmsAlarm=CmnbUtil.parserAlarm(alarm);

        EventInQueque event=new EventInQueque();
        event.setPushEventType(PushEventType.Alarm);
        event.setPushEventData(nmsAlarm);
        CmnbEventPush.getInstance().addEvent(event);
    }

    @Override
    public void update(Vector vector) throws RemoteException {
        for (int i = 0; i < vector.size(); i++) {
            Alarm alarm = (Alarm) vector.elementAt(i);
            if (alarm != null) {
                update(alarm);
            }
        }
    }
}
