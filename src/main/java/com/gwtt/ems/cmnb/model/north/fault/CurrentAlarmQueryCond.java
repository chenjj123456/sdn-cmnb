package com.gwtt.ems.cmnb.model.north.fault;

import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/8/29
 */
public class CurrentAlarmQueryCond extends CmnbBaseData {

    @XmlElement(name = "perceived-severity")
    private int perceivedSeverity;

    @XmlElement(name = "begin-alarm-raised-time")
    private String beginAlarmRaisedTime;

    @XmlElement(name = "end-alarm-raised-time")
    private String endAlarmRaisedTime;

    @XmlElement(name = "detail-alarm-source")
    private String detailAlarmSource;

    @XmlElement(name = "alarm-type")
    private int alarmType;

    @XmlElement(name = "probable-cause")
    private String probableCause;

    @XmlElement(name = "path-id")
    private String pathId;

    public int getPerceivedSeverity() {
        return perceivedSeverity;
    }

    public void setPerceivedSeverity(int perceivedSeverity) {
        this.perceivedSeverity = perceivedSeverity;
    }

    public String getBeginAlarmRaisedTime() {
        return beginAlarmRaisedTime;
    }

    public void setBeginAlarmRaisedTime(String beginAlarmRaisedTime) {
        this.beginAlarmRaisedTime = beginAlarmRaisedTime;
    }

    public String getEndAlarmRaisedTime() {
        return endAlarmRaisedTime;
    }

    public void setEndAlarmRaisedTime(String endAlarmRaisedTime) {
        this.endAlarmRaisedTime = endAlarmRaisedTime;
    }

    public String getDetailAlarmSource() {
        return detailAlarmSource;
    }

    public void setDetailAlarmSource(String detailAlarmSource) {
        this.detailAlarmSource = detailAlarmSource;
    }

    public int getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(int alarmType) {
        this.alarmType = alarmType;
    }

    public String getProbableCause() {
        return probableCause;
    }

    public void setProbableCause(String probableCause) {
        this.probableCause = probableCause;
    }

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }
}
