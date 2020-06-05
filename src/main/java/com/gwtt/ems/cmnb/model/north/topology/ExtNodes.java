package com.gwtt.ems.cmnb.model.north.topology;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/4
 */

@XmlRootElement(name = "ext-nodes", namespace="urn:chinamobile:nettopology")
public class ExtNodes {

    private List<ExtNode> extNode;

    public List<ExtNode> getExtNode() {
        return extNode;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "ext-node")
    public void setExtNode(List<ExtNode> extNode) {
        this.extNode = extNode;
    }
}
