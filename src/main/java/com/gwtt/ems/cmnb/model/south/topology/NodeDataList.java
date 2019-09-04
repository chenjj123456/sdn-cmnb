package com.gwtt.ems.cmnb.model.south.topology;

import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/4
 */
public class NodeDataList extends EmsBaseData {
    private List<NodeData> nodeDataList;

    public List<NodeData> getNodeDataList() {
        return nodeDataList;
    }

    public void setNodeDataList(List<NodeData> nodeDataList) {
        this.nodeDataList = nodeDataList;
    }
}
