package com.gwtt.ems.cmnb.model.north.route;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.gwtt.ems.cmnb.model.common.NeId;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/18
 */
public class RightNeIds {
    private List<NeId> rightNeId;

    public List<NeId> getRightNeId() {
        return rightNeId;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "right-ne-id")
    public void setRightNeId(List<NeId> rightNeId) {
        this.rightNeId = rightNeId;
    }
}
