package com.gwtt.ems.cmnb.model.north.notification;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/7/31
 */
@XmlRootElement(name = "output", namespace="urn:chinamobile:notification")
public class NotificationResponse {

    @XmlElement(name="notification-stream-identifier",namespace="urn:chinamobile:notification")
    private String notificationStreamIdentifier;

    public String getNotificationStreamIdentifier() {
        return notificationStreamIdentifier;
    }

    public void setNotificationStreamIdentifier(String notificationStreamIdentifier) {
        this.notificationStreamIdentifier = notificationStreamIdentifier;
    }
}
