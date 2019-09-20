package com.gwtt.ems.cmnb.model.north.route;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/19
 */
public class RerouteCalReq {

    private RerouteCalReqContainer rerouteCalReqContainer;

    public RerouteCalReqContainer getRerouteCalReqContainer() {
        return rerouteCalReqContainer;
    }

    @XmlElement(name = "reroute-cal-req-container")
    public void setRerouteCalReqContainer(RerouteCalReqContainer rerouteCalReqContainer) {
        this.rerouteCalReqContainer = rerouteCalReqContainer;
    }
}
