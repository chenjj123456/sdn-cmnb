package com.gwtt.ems.cmnb.model.north.tunnel;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/16
 */
public class ExplicitExcludeLinkList {
    private String linkId;

    public String getLinkId() {
        return linkId;
    }

    @XmlElement(name = "link-id")
    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }
}
