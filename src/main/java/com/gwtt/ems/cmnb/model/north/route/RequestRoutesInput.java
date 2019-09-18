package com.gwtt.ems.cmnb.model.north.route;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/9/18
 */
@XmlRootElement(name = "input")
public class RequestRoutesInput {
    private RouteCalReqs routeCalReqs;

    public RouteCalReqs getRouteCalReqs() {
        return routeCalReqs;
    }

    @XmlElement(name = "route-cal-reqs")
    public void setRouteCalReqs(RouteCalReqs routeCalReqs) {
        this.routeCalReqs = routeCalReqs;
    }
}
