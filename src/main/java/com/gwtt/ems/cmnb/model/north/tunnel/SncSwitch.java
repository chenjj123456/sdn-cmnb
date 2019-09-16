package com.gwtt.ems.cmnb.model.north.tunnel;

import com.gwtt.ems.cmnb.model.common.*;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/16
 */
public class SncSwitch {
    /**
     *id of pw or lsp ect.
     */
    private String sncId;

    /**
     *name of snc switch.
     */
    private String name;

    /**
     * layer rate. 0 : LSP, 1 : PW
     */
    private String layerRate;

    private LinearProtectionType linearProtectionType;

    private LinearProtectionProtocol linearProtectionProtocol;

    private SwitchMode switchMode;

    private RevertiveMode revertiveMode;

    /**
     * WTR.unit:s
     */
    private String wtr;


    /**
     * switch delay time. unit:ms. step:100ms
     */
    private String holdOffTime;

    private RerouteRevertiveMode rerouteRevertiveMode;

    private String rerouteWtr;

    public String getSncId() {
        return sncId;
    }

    @XmlElement(name = "snc-id")
    public void setSncId(String sncId) {
        this.sncId = sncId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLayerRate() {
        return layerRate;
    }

    @XmlElement(name = "layer-rate")
    public void setLayerRate(String layerRate) {
        this.layerRate = layerRate;
    }

    public LinearProtectionType getLinearProtectionType() {
        return linearProtectionType;
    }

    @XmlElement(name = "linear-protection-type")
    public void setLinearProtectionType(LinearProtectionType linearProtectionType) {
        this.linearProtectionType = linearProtectionType;
    }

    public LinearProtectionProtocol getLinearProtectionProtocol() {
        return linearProtectionProtocol;
    }

    @XmlElement(name = "linear-protection-protocol")
    public void setLinearProtectionProtocol(LinearProtectionProtocol linearProtectionProtocol) {
        this.linearProtectionProtocol = linearProtectionProtocol;
    }

    public SwitchMode getSwitchMode() {
        return switchMode;
    }

    @XmlElement(name = "switch-mode")
    public void setSwitchMode(SwitchMode switchMode) {
        this.switchMode = switchMode;
    }

    public RevertiveMode getRevertiveMode() {
        return revertiveMode;
    }

    @XmlElement(name = "revertive-mode")
    public void setRevertiveMode(RevertiveMode revertiveMode) {
        this.revertiveMode = revertiveMode;
    }

    public String getWtr() {
        return wtr;
    }

    public void setWtr(String wtr) {
        this.wtr = wtr;
    }

    public String getHoldOffTime() {
        return holdOffTime;
    }

    @XmlElement(name = "hold-off-time")
    public void setHoldOffTime(String holdOffTime) {
        this.holdOffTime = holdOffTime;
    }

    public RerouteRevertiveMode getRerouteRevertiveMode() {
        return rerouteRevertiveMode;
    }

    @XmlElement(name = "reroute-revertive-mode")
    public void setRerouteRevertiveMode(RerouteRevertiveMode rerouteRevertiveMode) {
        this.rerouteRevertiveMode = rerouteRevertiveMode;
    }

    public String getRerouteWtr() {
        return rerouteWtr;
    }

    @XmlElement(name = "reroute-wtr")
    public void setRerouteWtr(String rerouteWtr) {
        this.rerouteWtr = rerouteWtr;
    }
}
