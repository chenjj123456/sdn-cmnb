package com.gwtt.ems.cmnb.northInterface.topology;

import javax.ws.rs.core.Response;

/**
 * Created by chenjj on 2019/9/3
 */
public class TopologyNorthImpl implements TopoLogyNorthAPI{
    @Override
    public Response getTopologyByLayerRate(String layerRate) {
        return null;
    }

    @Override
    public Response getTopologyById(String id) {
        return null;
    }

    @Override
    public Response getTopoNodesByTopoId(String topoId) {
        return null;
    }

    @Override
    public Response getTopoExtNodesByTopoId(String topoId) {
        return null;
    }

    @Override
    public Response getTopoLinksByTopoId(String topoId) {
        return null;
    }

    @Override
    public Response getTopoExtLinksByTopoId(String topoId) {
        return null;
    }

    @Override
    public Response getTopoNodesByNodeId(String nodeId) {
        return null;
    }

    @Override
    public Response getTopoExtNodesByNodeId(String nodeId) {
        return null;
    }

    @Override
    public Response getTopoLinkTeAttrByLinkId(String linkId, String attr) {
        return null;
    }

    @Override
    public Response getTopoExtLinkTeAttrByLinkId(String linkId, String attr) {
        return null;
    }
}
