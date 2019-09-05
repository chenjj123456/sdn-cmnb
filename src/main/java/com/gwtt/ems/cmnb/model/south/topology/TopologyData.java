package com.gwtt.ems.cmnb.model.south.topology;

import com.gwtt.ems.cmnb.model.common.LayerRate;
import com.gwtt.ems.cmnb.model.common.SubLayerRate;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

/**
 * Created by chenjj on 2019/9/4
 */
public class TopologyData extends EmsBaseData {
    private String uuid;
    private String name;
    private LayerRate layerRate;
    private SubLayerRate subLayerRate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LayerRate getLayerRate() {
        return layerRate;
    }

    public void setLayerRate(LayerRate layerRate) {
        this.layerRate = layerRate;
    }

    public SubLayerRate getSubLayerRate() {
        return subLayerRate;
    }

    public void setSubLayerRate(SubLayerRate subLayerRate) {
        this.subLayerRate = subLayerRate;
    }
}
