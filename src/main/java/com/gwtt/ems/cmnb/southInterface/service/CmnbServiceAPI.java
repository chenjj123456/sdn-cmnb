package com.gwtt.ems.cmnb.southInterface.service;

import com.gwtt.ems.cmnb.model.south.topology.LinkDataList;
import com.gwtt.ems.cmnb.model.south.topology.NodeDataList;
import com.gwtt.ems.cmnb.model.south.topology.TopologyDataList;
import com.gwtt.ems.cmnb.southInterface.eventListener.CmnbEventListener;

/**
 * Created by chenjj on 2019/9/4
 */
public interface CmnbServiceAPI {

    public TopologyDataList getTopologyByLayerRate(String layerRate);
    public NodeDataList getTopoNodesByTopoId(String layerRate,String topoId);
    public NodeDataList getTopoExtNodesByTopoId(String layerRate,String topoId);
    public LinkDataList getTopoLinksByTopoId(String layerRate, String topoId);


    public void addListener(CmnbEventListener cmnbEventListener);

    public void shutdown(CmnbEventListener cmnbEventListener);
}
