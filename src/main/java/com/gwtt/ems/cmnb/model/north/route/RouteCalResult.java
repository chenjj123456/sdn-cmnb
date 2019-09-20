package com.gwtt.ems.cmnb.model.north.route;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/18
 */
public class RouteCalResult {

    private RouteCalResultContainer routeCalResultContainer;

    private Xcs xcs;

    private String sharedTunnelId;

    public RouteCalResultContainer getRouteCalResultContainer() {
        return routeCalResultContainer;
    }

    @XmlElement(name = "route-cal-result-container")
    public void setRouteCalResultContainer(RouteCalResultContainer routeCalResultContainer) {
        this.routeCalResultContainer = routeCalResultContainer;
    }

    public Xcs getXcs() {
        return xcs;
    }

    public void setXcs(Xcs xcs) {
        this.xcs = xcs;
    }

    public String getSharedTunnelId() {
        return sharedTunnelId;
    }

    @XmlElement(name = "shared-tunnel-id")
    public void setSharedTunnelId(String sharedTunnelId) {
        this.sharedTunnelId = sharedTunnelId;
    }
}
