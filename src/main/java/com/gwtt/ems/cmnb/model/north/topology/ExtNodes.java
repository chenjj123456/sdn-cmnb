package com.gwtt.ems.cmnb.model.north.topology;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/4
 */

@XmlRootElement(name = "ext-nodes", namespace="urn:chinamobile:nettopology")
public class ExtNodes {
    @XmlElement(name = "ext-node")
    private List<ExtNode> extNode;

    public List<ExtNode> getExtNode() {
        return extNode;
    }

    public void setExtNode(List<ExtNode> extNode) {
        this.extNode = extNode;
    }
}
