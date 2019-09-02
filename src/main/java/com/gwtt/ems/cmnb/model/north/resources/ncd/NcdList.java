package com.gwtt.ems.cmnb.model.north.resources.ncd;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/1
 */

@XmlRootElement(name = "ncd-list", namespace="urn:chinamobile:resource")
public class NcdList {
    private List<Ncd> ncd;

    public List<Ncd> getNcd() {
        return ncd;
    }

    public void setNcd(List<Ncd> ncd) {
        this.ncd = ncd;
    }
}
