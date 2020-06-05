package com.gwtt.ems.cmnb.model.north.route;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/18
 */
@XmlRootElement(name = "output")
public class RequestRoutesOutput {

    private List<RouteCalResult> routeCalResult;

    public List<RouteCalResult> getRouteCalResult() {
        return routeCalResult;
    }

    @XmlElementWrapper(name = "route-cal-results")
    @XmlElement(name = "route-cal-result")
    public void setRouteCalResult(List<RouteCalResult> routeCalResult) {
        this.routeCalResult = routeCalResult;
    }
}
