package com.gwtt.ems.cmnb.model.north.route;

import com.gwtt.ems.cmnb.model.common.CalPolicy;
import com.gwtt.ems.cmnb.model.common.NeLinkConstraint;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/18
 */
public class CalculateConstraint extends NeLinkConstraint {

    private Long bandwidth;

    private CalPolicy calPolicy;

    public Long getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Long bandwidth) {
        this.bandwidth = bandwidth;
    }

    public CalPolicy getCalPolicy() {
        return calPolicy;
    }

    @XmlElement(name = "cal-policy")
    public void setCalPolicy(CalPolicy calPolicy) {
        this.calPolicy = calPolicy;
    }
}
