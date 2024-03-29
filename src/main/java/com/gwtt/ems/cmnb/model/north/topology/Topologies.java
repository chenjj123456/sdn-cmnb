package com.gwtt.ems.cmnb.model.north.topology;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/4
 */


@XmlRootElement(name = "topologies", namespace="urn:chinamobile:nettopology")
public class Topologies {
    private List<Topology> topology;

    public List<Topology> getTopology() {
        return topology;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    public void setTopology(List<Topology> topology) {
        this.topology = topology;
    }
}
