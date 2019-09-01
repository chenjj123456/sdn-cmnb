package com.gwtt.ems.cmnb.model.north.resources;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/1
 */
public class Ncds {
    @XmlElement(name = "ncd-list")
    private NcdList ncdList;

    public NcdList getNcdList() {
        return ncdList;
    }

    public void setNcdList(NcdList ncdList) {
        this.ncdList = ncdList;
    }
}
