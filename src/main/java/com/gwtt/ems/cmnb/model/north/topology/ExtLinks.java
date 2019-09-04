package com.gwtt.ems.cmnb.model.north.topology;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/4
 */

@XmlRootElement(name = "ext-links", namespace="urn:chinamobile:nettopology")
public class ExtLinks {
    private List<ExtLink> extLink;

    public List<ExtLink> getExtLink() {
        return extLink;
    }

    public void setExtLink(List<ExtLink> extLink) {
        this.extLink = extLink;
    }
}
