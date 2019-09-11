package com.gwtt.ems.cmnb.model.north.notification;


import com.gwtt.ems.cmnb.model.north.fault.AlarmList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by chenjj on 2019/8/2
 */

public class AlarmsNotification{

    private List<AlarmList> alarmList;

    @XmlElementWrapper(name = "alarms")
    @XmlElement(name = "alarm-list")
    public List<AlarmList> getAlarmList() {
        return alarmList;
    }

    public void setAlarmList(List<AlarmList> alarmList) {
        this.alarmList = alarmList;
    }
}
