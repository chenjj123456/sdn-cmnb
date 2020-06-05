package com.gwtt.ems.cmnb.model.north.fault;

import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigInteger;


/**
 * Created by chenjj on 2019/8/2
 */

public class AlarmList extends CmnbBaseData {

    private BigInteger sequence;

    @XmlElement(name = "probable-cause")
    private String probableCause;

    @XmlElement(name = "perceived-severity")
    private int perceivedSeverity;

    @XmlElement(name = "alarm-raised-time")
    private String alarmRaisedTime;

    @XmlElement(name = "alarm-source-type")
    private int alarmSourceType;

    @XmlElement(name = "alarm-source")
    private String alarmSource;

    @XmlElement(name = "alarm-cleared-time")
    private String alarmClearedTime;

    @XmlElement(name = "path-ids")
    private PathIds pathIds;

    public BigInteger getSequence() {
        return sequence;
    }

    public void setSequence(BigInteger sequence) {
        this.sequence = sequence;
    }

    public String getProbableCause() {
        return probableCause;
    }

    public void setProbableCause(String probableCause) {
        this.probableCause = probableCause;
    }

    public int getPerceivedSeverity() {
        return perceivedSeverity;
    }

    public void setPerceivedSeverity(int perceivedSeverity) {
        this.perceivedSeverity = perceivedSeverity;
    }

    public String getAlarmRaisedTime() {
        return alarmRaisedTime;
    }

    public void setAlarmRaisedTime(String alarmRaisedTime) {
        this.alarmRaisedTime = alarmRaisedTime;
    }

    public int getAlarmSourceType() {
        return alarmSourceType;
    }

    public void setAlarmSourceType(int alarmSourceType) {
        this.alarmSourceType = alarmSourceType;
    }

    public String getAlarmSource() {
        return alarmSource;
    }

    public void setAlarmSource(String alarmSource) {
        this.alarmSource = alarmSource;
    }

    public String getAlarmClearedTime() {
        return alarmClearedTime;
    }

    public void setAlarmClearedTime(String alarmClearedTime) {
        this.alarmClearedTime = alarmClearedTime;
    }

    public PathIds getPathIds() {
        return pathIds;
    }

    public void setPathIds(PathIds pathIds) {
        this.pathIds = pathIds;
    }
}
