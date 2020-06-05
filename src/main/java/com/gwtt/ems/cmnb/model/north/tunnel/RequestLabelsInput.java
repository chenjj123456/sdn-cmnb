package com.gwtt.ems.cmnb.model.north.tunnel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/9/19
 */

@XmlRootElement(name = "input")
public class RequestLabelsInput {

    private NeIds neIds;

    private Long labelNumber;

    public NeIds getNeIds() {
        return neIds;
    }

    @XmlElement(name = "ne-ids")
    public void setNeIds(NeIds neIds) {
        this.neIds = neIds;
    }

    public Long getLabelNumber() {
        return labelNumber;
    }

    @XmlElement(name = "label-number")
    public void setLabelNumber(Long labelNumber) {
        this.labelNumber = labelNumber;
    }
}
