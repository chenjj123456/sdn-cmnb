package com.gwtt.ems.cmnb.model.north.notification;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/7/31
 */
@XmlRootElement(name = "input", namespace="urn:chinamobile:notification")
public class NotificationRequest{
    private String notifications;

    public String getNotifications() {
        return notifications;
    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }
}
