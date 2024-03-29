package com.gwtt.ems.cmnb.model.north.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/8/26
 */

public class Updates {

    private List<CmnbBaseData> updateList;

    public List<CmnbBaseData> getUpdateList() {
        return updateList;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "update-list")
    public void setUpdateList(List<CmnbBaseData> updateList) {
        this.updateList = updateList;
    }
}
