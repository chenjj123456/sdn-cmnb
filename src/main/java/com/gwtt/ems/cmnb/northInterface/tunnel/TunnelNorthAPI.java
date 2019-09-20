package com.gwtt.ems.cmnb.northInterface.tunnel;

import com.gwtt.ems.cmnb.model.north.tunnel.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by chenjj on 2019/9/16
 */

public interface TunnelNorthAPI {

    @GET
    @Path("/data/sptn-service-tunnel:service/snc-tunnels")
    @Produces({MediaType.APPLICATION_XML})
    Response getAllSncTunnels(@QueryParam("depth") int dep ,@QueryParam("source-ne-id") String srcNeId, @QueryParam("destination-ne-id") String dstNeId, @QueryParam("ncd") String ncdId);

    @GET
    @Path("/data/sptn-service-tunnel:service/snc-tunnels/snc-tunnel={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response getSncTunnelsById(@PathParam("id") String tunnelId, @QueryParam("depth") int depth);

    @POST
    @Path("/operations/sptn-service-tunnel:create-tunnel")
    @Produces({MediaType.APPLICATION_XML})
    Response createTunnel(CreateTunnelInput input);

    @POST
    @Path("/operations/sptn-service-tunnel:delete-tunnel")
    @Produces({MediaType.APPLICATION_XML})
    Response deleteTunnel(DeleteTunnelInput input);

    @PUT
    @Path("/data/sptn-service-tunnel:service/snc-tunnels/snc-tunnel={id}")
    @Produces({MediaType.APPLICATION_XML})
    Response modifyTunnelBasicProperty(@PathParam("id") String tunnelId, String userLabel);

    @PUT
    @Path("/data/sptn-service-tunnel:service/snc-tunnels/snc-tunnel={id}/qos")
    @Produces({MediaType.APPLICATION_XML})
    Response modifyTunnelQos(@PathParam("id") String tunnelId, Qos qos);

    @PUT
    @Path("/data/sptn-service-tunnel:service/snc-tunnels/snc-tunnel={id}/snc-switch")
    @Produces({MediaType.APPLICATION_XML})
    Response modifyTunnelSwitchProperty(@PathParam("id") String tunnelId, SncSwitch sncSwitch);

    @PUT
    @Path("/data/sptn-service-tunnel:service/snc-tunnels/snc-tunnel={tunnelid}/snc-lsps/snc-lsp={lspid}/oam")
    @Produces({MediaType.APPLICATION_XML})
    Response modifyLspOam(@PathParam("tunnelid") String tunnelId, @PathParam("lspid") String lspId, Oam oam);


    @POST
    @Path("/operations/sptn-service-tunnel:request-labels")
    @Produces({MediaType.APPLICATION_XML})
    Response requestLabels(RequestLabelsInput input);

    @POST
    @Path("/operations/sptn-service-tunnel:request-megid-spaces")
    @Produces({MediaType.APPLICATION_XML})
    Response requestMegidSpaces(RequestMegidSpacesInput input);
}
