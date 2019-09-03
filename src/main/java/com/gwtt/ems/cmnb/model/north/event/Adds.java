package com.gwtt.ems.cmnb.model.north.event;

import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/8/26
 */
public class Adds {

    @XmlElement(name = "add-list")
    private List<CmnbBaseData> addList;

    public List<CmnbBaseData> getAddList() {
        return addList;
    }

    public void setAddList(List<CmnbBaseData> addList) {
        this.addList = addList;
    }
}
