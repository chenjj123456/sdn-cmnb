package com.gwtt.ems.cmnb.model.north.fault;

import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigInteger;


/**
 * Created by chenjj on 2019/8/2
 */

public class AlarmList extends CmnbBaseData {

    private BigInteger sequence;

    private String probableCause;

    private int perceivedSeverity;

    private String alarmRaisedTime;

    private int alarmSourceType;

    private String alarmSource;

    private String alarmClearedTime;

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

    @XmlElement(name = "probable-cause")
    public void setProbableCause(String probableCause) {
        this.probableCause = probableCause;
    }

    public int getPerceivedSeverity() {
        return perceivedSeverity;
    }

    @XmlElement(name = "perceived-severity")
    public void setPerceivedSeverity(int perceivedSeverity) {
        this.perceivedSeverity = perceivedSeverity;
    }

    public String getAlarmRaisedTime() {
        return alarmRaisedTime;
    }

    @XmlElement(name = "alarm-raised-time")
    public void setAlarmRaisedTime(String alarmRaisedTime) {
        this.alarmRaisedTime = alarmRaisedTime;
    }

    public int getAlarmSourceType() {
        return alarmSourceType;
    }

    @XmlElement(name = "alarm-source-type")
    public void setAlarmSourceType(int alarmSourceType) {
        this.alarmSourceType = alarmSourceType;
    }

    public String getAlarmSource() {
        return alarmSource;
    }

    @XmlElement(name = "alarm-source")
    public void setAlarmSource(String alarmSource) {
        this.alarmSource = alarmSource;
    }

    public String getAlarmClearedTime() {
        return alarmClearedTime;
    }

    @XmlElement(name = "alarm-cleared-time")
    public void setAlarmClearedTime(String alarmClearedTime) {
        this.alarmClearedTime = alarmClearedTime;
    }

    public PathIds getPathIds() {
        return pathIds;
    }

    @XmlElement(name = "path-ids")
    public void setPathIds(PathIds pathIds) {
        this.pathIds = pathIds;
    }
}
