package com.gwtt.ems.cmnb.northInterface.topology;

import com.gwtt.ems.cmnb.model.north.topology.ExtLink;
import com.gwtt.ems.cmnb.model.north.topology.Link;
import com.gwtt.ems.cmnb.model.north.topology.LinkTeAttrCfg;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by chenjj on 2019/9/3
 */

@Path("/data/sptn-net-topology:net-topology")
public interface TopoLogyNorthAPI {
    @GET
    @Path("/topologies")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopologyByLayerRate(@QueryParam("layer-rate") String layerRate);

    @GET
    @Path("/topologies/topology={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopologyById(@PathParam(value = "id") String id);

    @GET
    @Path("/nodes")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoNodesByTopoId(@QueryParam("parent-topo-id") String topoId);

    @GET
    @Path("/ext-nodes")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoExtNodesByTopoId(@QueryParam(value = "parent-topo-id") String topoId);

    @GET
    @Path("/links")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoLinksByTopoId(@QueryParam(value = "parent-topo-id") String topoId);

    @GET
    @Path("/ext-links")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoExtLinksByTopoId(@QueryParam(value = "parent-topo-id") String topoId);

    @GET
    @Path("/nodes/node={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoNodeByNodeId(@PathParam(value = "id") String nodeId);

    @GET
    @Path("/ext-nodes/ext-node={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoExtNodeByNodeId(@PathParam(value = "id") String nodeId);

    @GET
    @Path("/links/link={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoLinkByLinkId(@PathParam(value = "id") String linkId);

    @GET
    @Path("/ext-links/ext-link={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoExtLinkByLinkId(@PathParam(value = "id") String linkId);

    @GET
    @Path("/links/link={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoLinkTeAttrByLinkId(@PathParam(value = "id") String linkId, @QueryParam("attr-run") String attr);

    @GET
    @Path("/ext-links/ext-link={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getTopoExtLinkTeAttrByLinkId(@PathParam(value = "id") String linkId, @QueryParam("attr-run") String attr);

    @POST
    @Path("/ext-links")
    @Produces({MediaType.APPLICATION_XML})
    Response createExtLink(ExtLink extLink);

    @DELETE
    @Path("/ext-links/ext-link={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response deleteExtLink(@PathParam(value = "id") String linkId);

    @PUT
    @Path("/links/link={id}/link-te-attr-cfg")
    @Produces({MediaType.APPLICATION_XML})
    Response configLink(@PathParam(value = "id") String linkId,LinkTeAttrCfg linkTeAttrCfg);

    @POST
    @Path("/links")
    @Produces({MediaType.APPLICATION_XML})
    Response createLink(Link link);

    @DELETE
    @Path("/links/link={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response deleteLink(@PathParam(value = "id") String linkId);
}
