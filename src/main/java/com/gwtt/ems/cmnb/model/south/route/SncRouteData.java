package com.gwtt.ems.cmnb.model.south.route;

import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/17
 */
public class SncRouteData extends EmsBaseData {
    private String uuid;

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

    private List<XcData> xcDataList;

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

    public String getLayerRate() {
        return layerRate;
    }

    public void setLayerRate(String layerRate) {
        this.layerRate = layerRate;
    }

    public String getSncId() {
        return sncId;
    }

    public void setSncId(String sncId) {
        this.sncId = sncId;
    }

    public List<XcData> getXcDataList() {
        return xcDataList;
    }

    public void setXcDataList(List<XcData> xcDataList) {
        this.xcDataList = xcDataList;
    }
}
