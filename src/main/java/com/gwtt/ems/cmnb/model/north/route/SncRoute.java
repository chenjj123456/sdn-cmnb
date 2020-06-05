package com.gwtt.ems.cmnb.model.north.route;

import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/17
 */
public class SncRoute extends CmnbBaseData {
    private String name;

    /**
     * 0 : LSP, 1 : PW
     * default LSP
     */
    private String layerRate;

    /**
     * id of pw or lsp that route belong to.
     */
    private String sncId;

    private Xcs xcs;

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

    public String getSncId() {
        return sncId;
    }

    @XmlElement(name = "snc-id")
    public void setSncId(String sncId) {
        this.sncId = sncId;
    }

    public Xcs getXcs() {
        return xcs;
    }

    public void setXcs(Xcs xcs) {
        this.xcs = xcs;
    }
}
