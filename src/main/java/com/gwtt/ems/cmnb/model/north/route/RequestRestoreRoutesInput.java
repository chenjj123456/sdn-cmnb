package com.gwtt.ems.cmnb.model.north.route;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/9/19
 */
@XmlRootElement(name = "input")
public class RequestRestoreRoutesInput {

    private RerouteCalReqs rerouteCalReqs;

    public RerouteCalReqs getRerouteCalReqs() {
        return rerouteCalReqs;
    }

    @XmlElement(name = "reroute-cal-reqs")
    public void setRerouteCalReqs(RerouteCalReqs rerouteCalReqs) {
        this.rerouteCalReqs = rerouteCalReqs;
    }
}
