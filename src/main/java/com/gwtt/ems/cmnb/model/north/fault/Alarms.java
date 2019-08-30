package com.gwtt.ems.cmnb.model.north.fault;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/8/2
 */

public class Alarms {
    @XmlElement(name = "alarm-list")
    private List<AlarmList> alarmList;

    public List<AlarmList> getAlarmList() {
        return alarmList;
    }

    public void setAlarmList(List<AlarmList> alarmList) {
        this.alarmList = alarmList;
    }
}
