package com.gwtt.ems.cmnb.model.north.route;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/17
 */
public class XcList {
    private String neId;

    private String ingressLtpId;

    private String forwardInLabel;

    private String backwardOutLabel;

    /**
     * lsp : peer ip of forward port. pw : peer VC id
     */
    private String backwardPeerId;

    private String egressLtpId;

    private String forwardOutLabel;

    private String backwardInLabel;

    /**
     * lsp : peer ip of backward port. pw : peer VC id
     */
    private String forwardPeerId;

    private String egressVlan;

    private String ingressVlan;

    public String getNeId() {
        return neId;
    }

    @XmlElement(name = "ne-id")
    public void setNeId(String neId) {
        this.neId = neId;
    }

    public String getIngressLtpId() {
        return ingressLtpId;
    }

    @XmlElement(name = "ingress-ltp-id")
    public void setIngressLtpId(String ingressLtpId) {
        this.ingressLtpId = ingressLtpId;
    }

    public String getForwardInLabel() {
        return forwardInLabel;
    }

    @XmlElement(name = "forward-in-label")
    public void setForwardInLabel(String forwardInLabel) {
        this.forwardInLabel = forwardInLabel;
    }

    public String getBackwardOutLabel() {
        return backwardOutLabel;
    }

    @XmlElement(name = "backward-out-label")
    public void setBackwardOutLabel(String backwardOutLabel) {
        this.backwardOutLabel = backwardOutLabel;
    }

    public String getBackwardPeerId() {
        return backwardPeerId;
    }

    @XmlElement(name = "backward-peer-id")
    public void setBackwardPeerId(String backwardPeerId) {
        this.backwardPeerId = backwardPeerId;
    }

    public String getEgressLtpId() {
        return egressLtpId;
    }

    @XmlElement(name = "egress-ltp-id")
    public void setEgressLtpId(String egressLtpId) {
        this.egressLtpId = egressLtpId;
    }

    public String getForwardOutLabel() {
        return forwardOutLabel;
    }

    @XmlElement(name = "forward-out-label")
    public void setForwardOutLabel(String forwardOutLabel) {
        this.forwardOutLabel = forwardOutLabel;
    }

    public String getBackwardInLabel() {
        return backwardInLabel;
    }

    @XmlElement(name = "backward-in-label")
    public void setBackwardInLabel(String backwardInLabel) {
        this.backwardInLabel = backwardInLabel;
    }

    public String getForwardPeerId() {
        return forwardPeerId;
    }

    @XmlElement(name = "forward-peer-id")
    public void setForwardPeerId(String forwardPeerId) {
        this.forwardPeerId = forwardPeerId;
    }

    public String getEgressVlan() {
        return egressVlan;
    }

    @XmlElement(name = "egress-vlan")
    public void setEgressVlan(String egressVlan) {
        this.egressVlan = egressVlan;
    }

    public String getIngressVlan() {
        return ingressVlan;
    }

    @XmlElement(name = "ingress-vlan")
    public void setIngressVlan(String ingressVlan) {
        this.ingressVlan = ingressVlan;
    }
}
