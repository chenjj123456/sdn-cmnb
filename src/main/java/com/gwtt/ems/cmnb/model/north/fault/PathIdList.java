package com.gwtt.ems.cmnb.model.north.fault;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/8/29
 */
public class PathIdList {
    @XmlElement(name = "path-id")
    private String pathId;

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }
}
