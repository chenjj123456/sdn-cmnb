package com.gwtt.ems.cmnb.model.south.topology;

import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/4
 */
public class TopologyDataList extends EmsBaseData {
    private List<TopologyData> topologyDataList;

    public List<TopologyData> getTopologyDataList() {
        return topologyDataList;
    }

    public void setTopologyDataList(List<TopologyData> topologyDataList) {
        this.topologyDataList = topologyDataList;
    }
}
