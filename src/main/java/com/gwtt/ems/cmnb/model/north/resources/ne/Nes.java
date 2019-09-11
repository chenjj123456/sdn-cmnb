package com.gwtt.ems.cmnb.model.north.resources.ne;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/1
 */

@XmlRootElement(name = "nes")
public class Nes {

    @XmlElementWrapper(name = "ne-list")
    @XmlElement(name = "ne")
    private List<Ne> ne;

    public List<Ne> getNe() {
        return ne;
    }

    public void setNe(List<Ne> ne) {
        this.ne = ne;
    }
}
