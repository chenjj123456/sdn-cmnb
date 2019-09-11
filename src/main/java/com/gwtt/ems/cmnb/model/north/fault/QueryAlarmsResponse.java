
package com.gwtt.ems.cmnb.model.north.fault;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/8/29
 */

@XmlRootElement(name = "output")
public class QueryAlarmsResponse {
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
