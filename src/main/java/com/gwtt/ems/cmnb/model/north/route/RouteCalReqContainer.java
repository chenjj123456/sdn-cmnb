package com.gwtt.ems.cmnb.model.north.route;

import com.gwtt.ems.cmnb.model.common.*;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/18
 */
public class RouteCalReqContainer {
    private String sequenceNo;

    private CalculatePolicy calculatePolicy;

    private CalculateType calculateType;

    private CalculateMode calculateMode;

    private CalculateInterconnectionMode calculateInterconnectionMode;

    /**
     * 0:lsp   1:pw，填写lsp获取pw
     */
    private String layerRate;

    private LeftNeIds leftNeIds;

    private RightNeIds rightNeIds;

    private CalculateConstraint workCalculateConstraint;

    private CalculateConstraint protectCalculateConstraint;

    private TunnelUsePolicy tunnelUsePolicy;

    private String l3vpnId;

    /**
     * ip of gateway.
     */
    private String gwIp;

    /**
     * mask of gateway.
     */
    private String gwMask;

    /**
     * vlan of l2vpn
     */
    private String vlan;

    public String getSequenceNo() {
        return sequenceNo;
    }

    @XmlElement(name = "sequence-no")
    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public CalculatePolicy getCalculatePolicy() {
        return calculatePolicy;
    }

    @XmlElement(name = "calculate-policy")
    public void setCalculatePolicy(CalculatePolicy calculatePolicy) {
        this.calculatePolicy = calculatePolicy;
    }

    public CalculateType getCalculateType() {
        return calculateType;
    }

    @XmlElement(name = "calculate-type")
    public void setCalculateType(CalculateType calculateType) {
        this.calculateType = calculateType;
    }

    public CalculateMode getCalculateMode() {
        return calculateMode;
    }

    @XmlElement(name = "calculate-mode")
    public void setCalculateMode(CalculateMode calculateMode) {
        this.calculateMode = calculateMode;
    }

    public CalculateInterconnectionMode getCalculateInterconnectionMode() {
        return calculateInterconnectionMode;
    }

    @XmlElement(name = "calculate-interconnection-mode")
    public void setCalculateInterconnectionMode(CalculateInterconnectionMode calculateInterconnectionMode) {
        this.calculateInterconnectionMode = calculateInterconnectionMode;
    }

    public String getLayerRate() {
        return layerRate;
    }

    @XmlElement(name = "layer-rate")
    public void setLayerRate(String layerRate) {
        this.layerRate = layerRate;
    }

    public LeftNeIds getLeftNeIds() {
        return leftNeIds;
    }

    @XmlElement(name = "left-ne-ids")
    public void setLeftNeIds(LeftNeIds leftNeIds) {
        this.leftNeIds = leftNeIds;
    }

    public RightNeIds getRightNeIds() {
        return rightNeIds;
    }

    @XmlElement(name = "right-ne-ids")
    public void setRightNeIds(RightNeIds rightNeIds) {
        this.rightNeIds = rightNeIds;
    }

    public CalculateConstraint getWorkCalculateConstraint() {
        return workCalculateConstraint;
    }

    @XmlElement(name = "work-calculate-constraint")
    public void setWorkCalculateConstraint(CalculateConstraint workCalculateConstraint) {
        this.workCalculateConstraint = workCalculateConstraint;
    }

    public CalculateConstraint getProtectCalculateConstraint() {
        return protectCalculateConstraint;
    }

    @XmlElement(name = "protect-calculate-constraint")
    public void setProtectCalculateConstraint(CalculateConstraint protectCalculateConstraint) {
        this.protectCalculateConstraint = protectCalculateConstraint;
    }

    public TunnelUsePolicy getTunnelUsePolicy() {
        return tunnelUsePolicy;
    }

    @XmlElement(name = "tunnel-use-policy")
    public void setTunnelUsePolicy(TunnelUsePolicy tunnelUsePolicy) {
        this.tunnelUsePolicy = tunnelUsePolicy;
    }

    public String getL3vpnId() {
        return l3vpnId;
    }

    @XmlElement(name = "l3vpn-id")
    public void setL3vpnId(String l3vpnId) {
        this.l3vpnId = l3vpnId;
    }

    public String getGwIp() {
        return gwIp;
    }

    @XmlElement(name = "gw-ip")
    public void setGwIp(String gwIp) {
        this.gwIp = gwIp;
    }

    public String getGwMask() {
        return gwMask;
    }

    @XmlElement(name = "gw-mask")
    public void setGwMask(String gwMask) {
        this.gwMask = gwMask;
    }

    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan;
    }
}
