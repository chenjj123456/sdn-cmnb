package com.gwtt.ems.cmnb.model.north.resources.ncd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/9/1
 */
@XmlRootElement(name = "ncds", namespace="urn:chinamobile:resource")
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
