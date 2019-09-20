package com.gwtt.ems.cmnb.northInterface.route;

import com.gwtt.ems.cmnb.model.north.route.RequestRestoreRoutesInput;
import com.gwtt.ems.cmnb.model.north.route.RequestRoutesInput;
import com.gwtt.ems.cmnb.model.north.route.SncRoute;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by chenjj on 2019/9/18
 */
public interface RouteNorthAPI {
    @GET
    @Path("/data/sptn-service-route:service/snc-routes/snc-route")
    @Produces({MediaType.APPLICATION_XML})
    Response getSncRouteForPw(@QueryParam("snc-pw-id") String pwId , @QueryParam("snc-lsp-id") String lspId);

    @PUT
    @Path("/data/sptn-service-route:service/snc-routes/snc-route")
    @Produces({MediaType.APPLICATION_XML})
    Response modifyLspRouteProperty(@QueryParam("tunnelId") String tunnelId,@QueryParam("lspId") String lspId, SncRoute sncRoute);

    @POST
    @Path("/operations/sptn-service-route:request-routes")
    @Produces({MediaType.APPLICATION_XML})
    Response requestRoutes(RequestRoutesInput input);

    @POST
    @Path("/operations/sptn-service-route:requestrestore-routes")
    @Produces({MediaType.APPLICATION_XML})
    Response requestRestoreRoutes(RequestRestoreRoutesInput input);
}
