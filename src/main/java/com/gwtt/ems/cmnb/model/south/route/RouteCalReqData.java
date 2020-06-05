package com.gwtt.ems.cmnb.model.south.route;

import com.gwtt.ems.cmnb.model.common.*;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/19
 */
public class RouteCalReqData extends EmsBaseData {
    private String sequenceNo;

    private CalculatePolicy calculatePolicy;

    private CalculateType calculateType;

    private CalculateMode calculateMode;

    private CalculateInterconnectionMode calculateInterconnectionMode;

    /**
     * 0:lsp   1:pw，填写lsp获取pw
     */
    private String layerRate;

    private List<NeId> leftNeId;

    private List<NeId> rightNeId;

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

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public CalculatePolicy getCalculatePolicy() {
        return calculatePolicy;
    }

    public void setCalculatePolicy(CalculatePolicy calculatePolicy) {
        this.calculatePolicy = calculatePolicy;
    }

    public CalculateType getCalculateType() {
        return calculateType;
    }

    public void setCalculateType(CalculateType calculateType) {
        this.calculateType = calculateType;
    }

    public CalculateMode getCalculateMode() {
        return calculateMode;
    }

    public void setCalculateMode(CalculateMode calculateMode) {
        this.calculateMode = calculateMode;
    }

    public CalculateInterconnectionMode getCalculateInterconnectionMode() {
        return calculateInterconnectionMode;
    }

    public void setCalculateInterconnectionMode(CalculateInterconnectionMode calculateInterconnectionMode) {
        this.calculateInterconnectionMode = calculateInterconnectionMode;
    }

    public String getLayerRate() {
        return layerRate;
    }

    public void setLayerRate(String layerRate) {
        this.layerRate = layerRate;
    }

    public List<NeId> getLeftNeId() {
        return leftNeId;
    }

    public void setLeftNeId(List<NeId> leftNeId) {
        this.leftNeId = leftNeId;
    }

    public List<NeId> getRightNeId() {
        return rightNeId;
    }

    public void setRightNeId(List<NeId> rightNeId) {
        this.rightNeId = rightNeId;
    }

    public CalculateConstraint getWorkCalculateConstraint() {
        return workCalculateConstraint;
    }

    public void setWorkCalculateConstraint(CalculateConstraint workCalculateConstraint) {
        this.workCalculateConstraint = workCalculateConstraint;
    }

    public CalculateConstraint getProtectCalculateConstraint() {
        return protectCalculateConstraint;
    }

    public void setProtectCalculateConstraint(CalculateConstraint protectCalculateConstraint) {
        this.protectCalculateConstraint = protectCalculateConstraint;
    }

    public TunnelUsePolicy getTunnelUsePolicy() {
        return tunnelUsePolicy;
    }

    public void setTunnelUsePolicy(TunnelUsePolicy tunnelUsePolicy) {
        this.tunnelUsePolicy = tunnelUsePolicy;
    }

    public String getL3vpnId() {
        return l3vpnId;
    }

    public void setL3vpnId(String l3vpnId) {
        this.l3vpnId = l3vpnId;
    }

    public String getGwIp() {
        return gwIp;
    }

    public void setGwIp(String gwIp) {
        this.gwIp = gwIp;
    }

    public String getGwMask() {
        return gwMask;
    }

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
