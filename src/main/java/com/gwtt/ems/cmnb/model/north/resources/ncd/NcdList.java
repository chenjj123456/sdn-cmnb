package com.gwtt.ems.cmnb.model.north.resources.ncd;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by chenjj on 2019/9/1
 */

@XmlRootElement(name = "ncd-list")
public class NcdList {
private Ncd ncd;

    public Ncd getNcd() {
        return ncd;
    }

    public void setNcd(Ncd ncd) {
        this.ncd = ncd;
    }
}
