package com.gwtt.ems.cmnb.southInterface.service;

import com.gwtt.ems.cmnb.model.south.EmsConfigOrQueryResult;
import com.gwtt.ems.cmnb.model.south.topology.*;
import com.gwtt.ems.cmnb.southInterface.eventListener.CmnbEventListener;

/**
 * Created by chenjj on 2019/9/4
 */
public interface CmnbServiceAPI {

    public TopologyDataList getTopologyByLayerRate(String layerRate);
    public NodeDataList getTopoNodesByTopoId(String layerRate,String topoId);
    public NodeDataList getTopoExtNodesByTopoId(String layerRate,String topoId);
    public LinkDataList getTopoLinksByTopoId(String layerRate, String topoId);
    public LinkDataList getTopoExtLinksByTopoId(String layerRate, String topoId);
    public NodeData getTopoNodeByNodeId(String layerRate, String nodeId);
    public NodeData getTopoExtNodeByNodeId(String layerRate, String nodeId);
    public LinkData getTopoLinkByLinkId(String layerRate, String linkId);
    public LinkData getTopoExtLinkByLinkId(String layerRate, String linkId);
    public EmsConfigOrQueryResult createExtLink(String layerRate,LinkData linkData);
    public EmsConfigOrQueryResult createLink(String layerRate,LinkData linkData);
    public EmsConfigOrQueryResult deleteExtLink(String layerRate,String linkId);
    public EmsConfigOrQueryResult deleteLink(String layerRate,String linkId);
    public EmsConfigOrQueryResult configLink(String layerRate,LinkData linkData);


    public void addListener(CmnbEventListener cmnbEventListener);

    public void shutdown(CmnbEventListener cmnbEventListener);
}
