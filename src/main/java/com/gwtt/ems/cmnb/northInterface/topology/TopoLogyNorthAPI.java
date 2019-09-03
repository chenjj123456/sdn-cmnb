package com.gwtt.ems.cmnb.northInterface.topology;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by chenjj on 2019/9/3
 */
public interface TopoLogyNorthAPI {
    @GET
    @Path("/data/sptn-net-topology:net-topology/topologies")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopologyByLayerRate(@QueryParam("layer-rate") String layerRate);

    @GET
    @Path("/data/sptn-net-topology:net-topology/topologies/topology={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopologyById(@PathParam(value = "id") String id);

    @GET
    @Path("/data/sptn-net-topology:net-topology/nodes")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoNodesByTopoId(@QueryParam("parent-topo-id") String topoId);

    @GET
    @Path("/data/sptn-net-topology:net-topology/ext-nodes")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoExtNodesByTopoId(@QueryParam(value = "parent-topo-id") String topoId);

    @GET
    @Path("/data/sptn-net-topology:net-topology/links")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoLinksByTopoId(@QueryParam(value = "parent-topo-id") String topoId);

    @GET
    @Path("/data/sptn-net-topology:net-topology/ext-links")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoExtLinksByTopoId(@QueryParam(value = "parent-topo-id") String topoId);

    @GET
    @Path("/data/sptn-net-topology:net-topology/nodes/node={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoNodesByNodeId(@PathParam(value = "id") String nodeId);

    @GET
    @Path("/data/sptn-net-topology:net-topology/ext-nodes/ext-node={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoExtNodesByNodeId(@PathParam(value = "id") String nodeId);

    @GET
    @Path("/data/sptn-net-topology:net-topology/links/link={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoLinkTeAttrByLinkId(@PathParam(value = "id") String linkId, @QueryParam("attr-run") String attr);

    @GET
    @Path("/data/sptn-net-topology:net-topology/ext-links/ext-link={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoExtLinkTeAttrByLinkId(@PathParam(value = "id") String linkId, @QueryParam("attr-run") String attr);
}
