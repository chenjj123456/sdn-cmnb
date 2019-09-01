package com.gwtt.ems.cmnb.model.north.resources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/9/1
 */

@XmlRootElement(name = "input")
public class GetSpeccifiedNcdRequest {

    @XmlElement(name = "ncd-id")
    private String ncdId;

    public String getNcdId() {
        return ncdId;
    }

    public void setNcdId(String ncdId) {
        this.ncdId = ncdId;
    }
}
