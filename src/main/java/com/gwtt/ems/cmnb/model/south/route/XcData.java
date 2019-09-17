package com.gwtt.ems.cmnb.model.south.route;

import com.gwtt.ems.cmnb.model.south.EmsBaseData;

/**
 * Created by chenjj on 2019/9/17
 */
public class XcData extends EmsBaseData {
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

    public void setNeId(String neId) {
        this.neId = neId;
    }

    public String getIngressLtpId() {
        return ingressLtpId;
    }

    public void setIngressLtpId(String ingressLtpId) {
        this.ingressLtpId = ingressLtpId;
    }

    public String getForwardInLabel() {
        return forwardInLabel;
    }

    public void setForwardInLabel(String forwardInLabel) {
        this.forwardInLabel = forwardInLabel;
    }

    public String getBackwardOutLabel() {
        return backwardOutLabel;
    }

    public void setBackwardOutLabel(String backwardOutLabel) {
        this.backwardOutLabel = backwardOutLabel;
    }

    public String getBackwardPeerId() {
        return backwardPeerId;
    }

    public void setBackwardPeerId(String backwardPeerId) {
        this.backwardPeerId = backwardPeerId;
    }

    public String getEgressLtpId() {
        return egressLtpId;
    }

    public void setEgressLtpId(String egressLtpId) {
        this.egressLtpId = egressLtpId;
    }

    public String getForwardOutLabel() {
        return forwardOutLabel;
    }

    public void setForwardOutLabel(String forwardOutLabel) {
        this.forwardOutLabel = forwardOutLabel;
    }

    public String getBackwardInLabel() {
        return backwardInLabel;
    }

    public void setBackwardInLabel(String backwardInLabel) {
        this.backwardInLabel = backwardInLabel;
    }

    public String getForwardPeerId() {
        return forwardPeerId;
    }

    public void setForwardPeerId(String forwardPeerId) {
        this.forwardPeerId = forwardPeerId;
    }

    public String getEgressVlan() {
        return egressVlan;
    }

    public void setEgressVlan(String egressVlan) {
        this.egressVlan = egressVlan;
    }

    public String getIngressVlan() {
        return ingressVlan;
    }

    public void setIngressVlan(String ingressVlan) {
        this.ingressVlan = ingressVlan;
    }
}
