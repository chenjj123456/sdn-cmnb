package com.gwtt.ems.cmnb.model.north.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/8/26
 */
public class Adds {


    private List<CmnbBaseData> addList;

    public List<CmnbBaseData> getAddList() {
        return addList;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "add-list")
    public void setAddList(List<CmnbBaseData> addList) {
        this.addList = addList;
    }
}
