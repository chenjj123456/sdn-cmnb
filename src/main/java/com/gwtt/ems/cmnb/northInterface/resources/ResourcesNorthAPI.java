package com.gwtt.ems.cmnb.northInterface.resources;

import com.gwtt.ems.cmnb.model.north.resources.ne.AddMeLocationRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by chenjj on 2019/7/24
 */

public interface ResourcesNorthAPI {

    @GET
    @Path("/data/sptn-resources-module:resources/nes")
    @Produces({MediaType.APPLICATION_XML})
    Response getNesByNcdId(@QueryParam("ncd-id") String ncdId);

    @GET
    @Path("/data/sptn-resources-module:resources/nes/ne-list/ne={neId}/ltps")
    @Produces({MediaType.APPLICATION_XML})
    Response getLtpsByNe(@PathParam(value = "neId") String neId);

    @GET
    @Path("/data/sptn-resources-module:resources/ncd-list/ncd={ncdId}")
    @Produces({MediaType.APPLICATION_XML})
    Response getNcdById(@PathParam(value = "ncdId") String ncdId);

    @GET
    @Path("/data/sptn-resources-module:resources/ncd-list")
    @Produces({MediaType.APPLICATION_XML})
    Response getNcds();

    @GET
    @Path("/data/sptn-resources-module:resources/nes/ne-list/ne={neId}")
    @Produces({MediaType.APPLICATION_XML})
    Response getNeById(@PathParam(value = "neId") String neId);

    //get all ncds according to the conditions
    @GET
    @Path("/operations/sptn-resources-module:get-all-ncds")
    @Produces({MediaType.APPLICATION_XML})
    Response getAllNcds();

    @GET
    @Path("/operations/sptn-resources-module:get-specified-ncd")
    @Produces({MediaType.APPLICATION_XML})
    Response getSpecifiedNcd();

    @POST
    @Path("/operations/sptn-resources-module:add-me-location")
    @Produces({MediaType.APPLICATION_XML})
    Response addMeLocation(AddMeLocationRequest request);


}
