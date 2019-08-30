package com.gwtt.ems.cmnb.model.north.fault;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/8/29
 */
public class PathIds {

    @XmlElement(name = "path-id-list")
    private List<PathIdList> pathIdList;

    public List<PathIdList> getPathIdList() {
        return pathIdList;
    }

    public void setPathIdList(List<PathIdList> pathIdList) {
        this.pathIdList = pathIdList;
    }
}
