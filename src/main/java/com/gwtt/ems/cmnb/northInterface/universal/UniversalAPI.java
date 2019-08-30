package com.gwtt.ems.cmnb.northInterface.universal;



import com.gwtt.ems.cmnb.model.north.notification.NotificationRequest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by chenjj on 2019/8/1
 */
public interface UniversalAPI {

    @GET
    @Path("/operations/sptn-hmf-module:do-heartbeat-hmf-controller")
    @Produces({MediaType.APPLICATION_XML})
    Response doHeartbeatHmfController();


    @POST
    @Path("/operations/sptn-notification:create-notification-stream")
    @Produces({MediaType.APPLICATION_XML})
    Response createNotificationStream(NotificationRequest request);
}
