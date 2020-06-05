package com.gwtt.ems.cmnb.model.south.tunnel;

import com.gwtt.ems.cmnb.model.common.*;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

/**
 * Created by chenjj on 2019/9/17
 */
public class SncSwitchData extends EmsBaseData {
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

    public void setLayerRate(String layerRate) {
        this.layerRate = layerRate;
    }

    public LinearProtectionType getLinearProtectionType() {
        return linearProtectionType;
    }

    public void setLinearProtectionType(LinearProtectionType linearProtectionType) {
        this.linearProtectionType = linearProtectionType;
    }

    public LinearProtectionProtocol getLinearProtectionProtocol() {
        return linearProtectionProtocol;
    }

    public void setLinearProtectionProtocol(LinearProtectionProtocol linearProtectionProtocol) {
        this.linearProtectionProtocol = linearProtectionProtocol;
    }

    public SwitchMode getSwitchMode() {
        return switchMode;
    }

    public void setSwitchMode(SwitchMode switchMode) {
        this.switchMode = switchMode;
    }

    public RevertiveMode getRevertiveMode() {
        return revertiveMode;
    }

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

    public void setHoldOffTime(String holdOffTime) {
        this.holdOffTime = holdOffTime;
    }

    public RerouteRevertiveMode getRerouteRevertiveMode() {
        return rerouteRevertiveMode;
    }

    public void setRerouteRevertiveMode(RerouteRevertiveMode rerouteRevertiveMode) {
        this.rerouteRevertiveMode = rerouteRevertiveMode;
    }

    public String getRerouteWtr() {
        return rerouteWtr;
    }

    public void setRerouteWtr(String rerouteWtr) {
        this.rerouteWtr = rerouteWtr;
    }
}
