package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/17
 */
public class SuccessResourceList {

    private String resourceId;

    public String getResourceId() {
        return resourceId;
    }

    @XmlElement(name = "resource-id")
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
