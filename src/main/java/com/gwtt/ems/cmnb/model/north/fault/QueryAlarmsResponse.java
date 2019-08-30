package com.gwtt.ems.cmnb.model.north.fault;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/8/29
 */

@XmlRootElement(name = "output")
public class QueryAlarmsResponse {
    private Alarms alarms;

    public Alarms getAlarms() {
        return alarms;
    }

    public void setAlarms(Alarms alarms) {
        this.alarms = alarms;
    }
}
