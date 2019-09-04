package com.gwtt.ems.cmnb.model.north.topology;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/4
 */
public class LinkTeAttrRun {

    @XmlElement(name = "physical-bandwidth")
    private Long physicalBandwidth;

    @XmlElement(name = "available-bandwidth")
    private Long availableBandwidth;

    @XmlElement(name = "link-latency")
    private Long linkLatency;

    public Long getPhysicalBandwidth() {
        return physicalBandwidth;
    }

    public void setPhysicalBandwidth(Long physicalBandwidth) {
        this.physicalBandwidth = physicalBandwidth;
    }

    public Long getAvailableBandwidth() {
        return availableBandwidth;
    }

    public void setAvailableBandwidth(Long availableBandwidth) {
        this.availableBandwidth = availableBandwidth;
    }

    public Long getLinkLatency() {
        return linkLatency;
    }

    public void setLinkLatency(Long linkLatency) {
        this.linkLatency = linkLatency;
    }
}
