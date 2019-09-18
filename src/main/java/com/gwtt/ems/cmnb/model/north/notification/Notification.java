package com.gwtt.ems.cmnb.model.north.notification;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/8/2
 */
@XmlRootElement(name = "notification", namespace="urn:chinamobile:notification")
public class Notification {
    private String eventTime;


    private AlarmsNotification alarmsNotification;

    private NeNotification neNotification;

    private LtpNotification ltpNotification;

    private NodeNotification nodeNotification;

    private LinkNotification linkNotification;

    private SncLspNotification sncLspNotification;

    private SncTunnelNotification sncTunnelNotification;


    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public AlarmsNotification getAlarmsNotification() {
        return alarmsNotification;
    }

    @XmlElement(name = "alarms-notification")
    public void setAlarmsNotification(AlarmsNotification alarmsNotification) {
        this.alarmsNotification = alarmsNotification;
    }

    public NeNotification getNeNotification() {
        return neNotification;
    }

    @XmlElement(name = "ne-notification")
    public void setNeNotification(NeNotification neNotification) {
        this.neNotification = neNotification;
    }

    public LtpNotification getLtpNotification() {
        return ltpNotification;
    }

    @XmlElement(name = "ltp-notification")
    public void setLtpNotification(LtpNotification ltpNotification) {
        this.ltpNotification = ltpNotification;
    }

    public NodeNotification getNodeNotification() {
        return nodeNotification;
    }

    @XmlElement(name = "node-notification")
    public void setNodeNotification(NodeNotification nodeNotification) {
        this.nodeNotification = nodeNotification;
    }

    public LinkNotification getLinkNotification() {
        return linkNotification;
    }

    @XmlElement(name = "link-notification")
    public void setLinkNotification(LinkNotification linkNotification) {
        this.linkNotification = linkNotification;
    }


    public SncLspNotification getSncLspNotification() {
        return sncLspNotification;
    }

    @XmlElement(name = "snc-lsp-notification")
    public void setSncLspNotification(SncLspNotification sncLspNotification) {
        this.sncLspNotification = sncLspNotification;
    }

    public SncTunnelNotification getSncTunnelNotification() {
        return sncTunnelNotification;
    }

    @XmlElement(name = "snc-tunnel-notification")
    public void setSncTunnelNotification(SncTunnelNotification sncTunnelNotification) {
        this.sncTunnelNotification = sncTunnelNotification;
    }
}
