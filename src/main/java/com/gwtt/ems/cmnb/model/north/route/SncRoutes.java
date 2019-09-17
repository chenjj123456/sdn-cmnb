package com.gwtt.ems.cmnb.model.north.route;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/17
 */
public class SncRoutes {
    private List<SncRoute> sncRoute;

    public List<SncRoute> getSncRoute() {
        return sncRoute;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "snc-route")
    public void setSncRoute(List<SncRoute> sncRoute) {
        this.sncRoute = sncRoute;
    }
}
