package com.gwtt.ems.cmnb.model.north.event;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/8/26
 */
public class Deletes {
    @XmlElement(name = "delete-list")
    private List<String> deleteList;

    public List<String> getDeleteList() {
        return deleteList;
    }

    public void setDeleteList(List<String> deleteList) {
        this.deleteList = deleteList;
    }
}
