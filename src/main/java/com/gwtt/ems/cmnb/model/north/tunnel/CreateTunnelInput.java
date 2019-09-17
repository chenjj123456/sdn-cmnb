package com.gwtt.ems.cmnb.model.north.tunnel;

import com.gwtt.ems.cmnb.model.north.route.SncRoute;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/17
 */
@XmlRootElement(name = "input")
public class CreateTunnelInput {

    private SncTunnel sncTunnel;

    private List<SncRoute> routes;

    public SncTunnel getSncTunnel() {
        return sncTunnel;
    }

    @XmlElement(name = "snc-tunnel")
    public void setSncTunnel(SncTunnel sncTunnel) {
        this.sncTunnel = sncTunnel;
    }

    public List<SncRoute> getRoutes() {
        return routes;
    }

    @XmlElementWrapper(name = "routes")
    @XmlElement(name = "route-list")
    public void setRoutes(List<SncRoute> routes) {
        this.routes = routes;
    }
}
