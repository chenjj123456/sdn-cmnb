package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/18
 */
public class LinkId {
    private String linkId;

    public String getLinkId() {
        return linkId;
    }

    @XmlElement(name = "link-id")
    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }
}
