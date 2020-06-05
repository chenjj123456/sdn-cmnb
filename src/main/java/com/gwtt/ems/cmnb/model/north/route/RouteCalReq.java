package com.gwtt.ems.cmnb.model.north.route;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/18
 */
public class RouteCalReq {

    private RouteCalReqContainer routeCalReqContainer;

    public RouteCalReqContainer getRouteCalReqContainer() {
        return routeCalReqContainer;
    }

    @XmlElement(name = "route-cal-req-container")
    public void setRouteCalReqContainer(RouteCalReqContainer routeCalReqContainer) {
        this.routeCalReqContainer = routeCalReqContainer;
    }
}
