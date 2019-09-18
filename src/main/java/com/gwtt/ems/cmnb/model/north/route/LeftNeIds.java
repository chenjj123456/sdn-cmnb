package com.gwtt.ems.cmnb.model.north.route;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.gwtt.ems.cmnb.model.common.NeId;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/18
 */
public class LeftNeIds {
    private List<NeId> leftNeId;

    public List<NeId> getLeftNeId() {
        return leftNeId;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "left-ne-id")
    public void setLeftNeId(List<NeId> leftNeId) {
        this.leftNeId = leftNeId;
    }
}
