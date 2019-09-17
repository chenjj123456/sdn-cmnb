package com.gwtt.ems.cmnb.model.north.topology;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlElement;
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

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "ext-link")
    public void setExtLink(List<ExtLink> extLink) {
        this.extLink = extLink;
    }
}
