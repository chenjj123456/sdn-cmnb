package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/20
 */
public class NeMegidSpace {

    private String neId;

    private String availableSpace;

    public String getNeId() {
        return neId;
    }

    @XmlElement(name = "ne-id")
    public void setNeId(String neId) {
        this.neId = neId;
    }

    public String getAvailableSpace() {
        return availableSpace;
    }

    @XmlElement(name = "available-space")
    public void setAvailableSpace(String availableSpace) {
        this.availableSpace = availableSpace;
    }
}
