package com.gwtt.ems.cmnb.model.south.topology;

import com.gwtt.ems.cmnb.model.common.LayerRate;
import com.gwtt.ems.cmnb.model.common.SubLayerRate;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

/**
 * Created by chenjj on 2019/9/4
 */
public class TopologyData extends EmsBaseData {
    private String id;
    private String name;
    private LayerRate layerRate;
    private SubLayerRate subLayerRate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
