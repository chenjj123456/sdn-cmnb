package com.gwtt.ems.cmnb.model.north.topology;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

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

    @JacksonXmlElementWrapper(useWrapping = false)
    public void setNode(List<Node> node) {
        this.node = node;
    }
}
