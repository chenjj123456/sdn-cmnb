package com.gwtt.ems.cmnb.model.north.route;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/19
 */
public class RerouteCalReqs {

    private List<RerouteCalReq> rerouteCalReq;

    public List<RerouteCalReq> getRerouteCalReq() {
        return rerouteCalReq;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "reroute-cal-req")
    public void setRerouteCalReq(List<RerouteCalReq> rerouteCalReq) {
        this.rerouteCalReq = rerouteCalReq;
    }
}
