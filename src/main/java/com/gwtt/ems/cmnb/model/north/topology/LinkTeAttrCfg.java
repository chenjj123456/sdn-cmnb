package com.gwtt.ems.cmnb.model.north.topology;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/4
 */
public class LinkTeAttrCfg {
    private Long latency;

    @XmlElement(name = "max-reservable-bandwidth")
    private Long maxReservableBandwidth;

    public Long getLatency() {
        return latency;
    }

    public void setLatency(Long latency) {
        this.latency = latency;
    }

    public Long getMaxReservableBandwidth() {
        return maxReservableBandwidth;
    }

    public void setMaxReservableBandwidth(Long maxReservableBandwidth) {
        this.maxReservableBandwidth = maxReservableBandwidth;
    }
}
