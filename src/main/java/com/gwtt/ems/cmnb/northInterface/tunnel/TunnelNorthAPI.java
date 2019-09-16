package com.gwtt.ems.cmnb.northInterface.tunnel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

}
