package com.gwtt.ems.cmnb.model.north.tunnel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/17
 */

@XmlRootElement(name = "snc-tunnels")
public class SncTunnels {
    private List<SncTunnel> sncTunnel;

    public List<SncTunnel> getSncTunnel() {
        return sncTunnel;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "snc-tunnel")
    public void setSncTunnel(List<SncTunnel> sncTunnel) {
        this.sncTunnel = sncTunnel;
    }
}
