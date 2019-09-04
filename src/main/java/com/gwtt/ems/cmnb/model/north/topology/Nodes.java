package com.gwtt.ems.cmnb.model.north.topology;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/4
 */

@XmlRootElement(name = "nodes", namespace="urn:chinamobile:nettopology")
public class Nodes {
    private List<Node> node;

    public List<Node> getNode() {
        return node;
    }

    public void setNode(List<Node> node) {
        this.node = node;
    }
}
