package com.gwtt.ems.cmnb.model.north.tunnel;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/16
 */
public class ExplicitExcludeNeList {
    private String neId;

    public String getNeId() {
        return neId;
    }

    @XmlElement(name = "ne-id")
    public void setNeId(String neId) {
        this.neId = neId;
    }
}
