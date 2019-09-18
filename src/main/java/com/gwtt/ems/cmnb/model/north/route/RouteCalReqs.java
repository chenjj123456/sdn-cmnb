package com.gwtt.ems.cmnb.model.north.route;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/18
 */
public class RouteCalReqs {

    private List<RouteCalReq> routeCalReq;

    public List<RouteCalReq> getRouteCalReq() {
        return routeCalReq;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "route-cal-req")
    public void setRouteCalReq(List<RouteCalReq> routeCalReq) {
        this.routeCalReq = routeCalReq;
    }
}
