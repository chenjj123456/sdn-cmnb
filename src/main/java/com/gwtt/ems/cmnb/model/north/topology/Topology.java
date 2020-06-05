package com.gwtt.ems.cmnb.model.north.topology;

import com.gwtt.ems.cmnb.model.common.LayerRate;
import com.gwtt.ems.cmnb.model.common.SubLayerRate;
import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/4
 */
public class Topology extends CmnbBaseData {
    private String name;

    private LayerRate layerRate;

    private SubLayerRate subLayerRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LayerRate getLayerRate() {
        return layerRate;
    }

    @XmlElement(name = "layer-rate")
    public void setLayerRate(LayerRate layerRate) {
        this.layerRate = layerRate;
    }

    public SubLayerRate getSubLayerRate() {
        return subLayerRate;
    }

    @XmlElement(name = "sub-layer-rate")
    public void setSubLayerRate(SubLayerRate subLayerRate) {
        this.subLayerRate = subLayerRate;
    }
}
