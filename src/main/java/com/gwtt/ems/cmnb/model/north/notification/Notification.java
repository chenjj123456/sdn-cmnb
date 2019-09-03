package com.gwtt.ems.cmnb.model.north.notification;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/8/2
 */
@XmlRootElement(name = "notification", namespace="urn:chinamobile:notification")
public class Notification {
    private String eventTime;

    @XmlElement(name = "alarms-notification")
    private AlarmsNotification alarmsNotification;

    @XmlElement(name = "ne-notification")
    private NeNotification neNotification;

    @XmlElement(name = "ltp-notification")
    private LtpNotification ltpNotification;

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public AlarmsNotification getAlarmsNotification() {
        return alarmsNotification;
    }

    public void setAlarmsNotification(AlarmsNotification alarmsNotification) {
        this.alarmsNotification = alarmsNotification;
    }

    public NeNotification getNeNotification() {
        return neNotification;
    }

    public void setNeNotification(NeNotification neNotification) {
        this.neNotification = neNotification;
    }

    public LtpNotification getLtpNotification() {
        return ltpNotification;
    }

    public void setLtpNotification(LtpNotification ltpNotification) {
        this.ltpNotification = ltpNotification;
    }
}
