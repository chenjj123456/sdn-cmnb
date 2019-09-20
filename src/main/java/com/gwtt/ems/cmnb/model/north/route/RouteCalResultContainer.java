package com.gwtt.ems.cmnb.model.north.route;

import com.gwtt.ems.cmnb.model.common.Role;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/19
 */
public class RouteCalResultContainer {

    private String sequenceNo;

    private String groupNo;

    private Role role;

    private String ingressNeId;

    private String egressNeId;

    /**
     * Latency. unit:ns
     * range "0..60000000"
     */
    private Long latency;

    /**
     * max availble bandwidth. unit:kbps
     * range "0..4000000000"
     */
    private Long maxAvailbleBandwidth;

    public String getSequenceNo() {
        return sequenceNo;
    }

    @XmlElement(name = "sequence-no")
    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getGroupNo() {
        return groupNo;
    }

    @XmlElement(name = "group-no")
    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getIngressNeId() {
        return ingressNeId;
    }

    @XmlElement(name = "ingress-ne-id")
    public void setIngressNeId(String ingressNeId) {
        this.ingressNeId = ingressNeId;
    }

    public String getEgressNeId() {
        return egressNeId;
    }

    @XmlElement(name = "egress-ne-id")
    public void setEgressNeId(String egressNeId) {
        this.egressNeId = egressNeId;
    }

    public Long getLatency() {
        return latency;
    }

    public void setLatency(Long latency) {
        this.latency = latency;
    }

    public Long getMaxAvailbleBandwidth() {
        return maxAvailbleBandwidth;
    }

    @XmlElement(name = "max-availble-bandwidth")
    public void setMaxAvailbleBandwidth(Long maxAvailbleBandwidth) {
        this.maxAvailbleBandwidth = maxAvailbleBandwidth;
    }
}
