package com.gwtt.ems.cmnb.model.north.resources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/9/1
 */

@XmlRootElement(name = "nes", namespace="urn:chinamobile:resource")
public class Nes {
    @XmlElement(name = "ne-list")
    private NeList neList;

    public NeList getNeList() {
        return neList;
    }

    public void setNeList(NeList neList) {
        this.neList = neList;
    }
}
