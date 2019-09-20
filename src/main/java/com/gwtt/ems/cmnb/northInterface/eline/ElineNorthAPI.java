package com.gwtt.ems.cmnb.northInterface.eline;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by chenjj on 2019/9/19
 */


public interface ElineNorthAPI {
    @GET
    @Path("/data/sptn-service-eline:service/snc-elines")
    @Produces({MediaType.APPLICATION_XML})
    Response getAllSncElines(@QueryParam("depth") int dep, @QueryParam("ncd") String ncdId);

}
