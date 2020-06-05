package com.gwtt.ems.cmnb.model.common;


import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/19
 */
public class NeIdList {

    private String neId;

    /**
     * 0 : LSP, 1 : PW
     * default LSP
     */
    private String layerRate;

    private DeviceRole role;

    /**
     * 'ctrl word support. 0 : not support, 1 : support'
     */
    private Byte ctrlWordSupport;

    public String getNeId() {
        return neId;
    }

    @XmlElement(name = "ne-id")
    public void setNeId(String neId) {
        this.neId = neId;
    }

    public String getLayerRate() {
        return layerRate;
    }

    @XmlElement(name = "layer-rate")
    public void setLayerRate(String layerRate) {
        this.layerRate = layerRate;
    }

    public DeviceRole getRole() {
        return role;
    }

    public void setRole(DeviceRole role) {
        this.role = role;
    }

    public Byte getCtrlWordSupport() {
        return ctrlWordSupport;
    }

    @XmlElement(name = "ctrl-word-support")
    public void setCtrlWordSupport(Byte ctrlWordSupport) {
        this.ctrlWordSupport = ctrlWordSupport;
    }
}
