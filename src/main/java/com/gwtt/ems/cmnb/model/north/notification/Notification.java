package com.gwtt.ems.cmnb.model.north.notification;

import com.gwtt.ems.cmnb.model.north.fault.AlarmsNotification;

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

//    private NeNotification neNotification;


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

}
