package com.gwtt.ems.cmnb.model.north.fault;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/8/29
 */
@XmlRootElement(name = "input")
public class QueryAlarmsRequest {

    @XmlElement(name = "current-alarm-query-cond")
    private CurrentAlarmQueryCond currentAlarmQueryCond;

    public CurrentAlarmQueryCond getCurrentAlarmQueryCond() {
        return currentAlarmQueryCond;
    }

    public void setCurrentAlarmQueryCond(CurrentAlarmQueryCond currentAlarmQueryCond) {
        this.currentAlarmQueryCond = currentAlarmQueryCond;
    }
}
