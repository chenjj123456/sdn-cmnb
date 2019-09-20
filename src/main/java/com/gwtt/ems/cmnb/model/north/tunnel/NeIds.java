package com.gwtt.ems.cmnb.model.north.tunnel;

import com.gwtt.ems.cmnb.model.common.NeIdList;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/19
 */
public class NeIds {
    private List<NeIdList> neIdList;

    public List<NeIdList> getNeIdList() {
        return neIdList;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "ne-id-list")
    public void setNeIdList(List<NeIdList> neIdList) {
        this.neIdList = neIdList;
    }
}
