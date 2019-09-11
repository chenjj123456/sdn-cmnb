package com.gwtt.ems.cmnb.northInterface.fm;

import com.gwtt.ems.cmnb.model.north.fault.CurrentAlarmQueryCond;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by chenjj on 2019/8/29
 */
public interface AlarmNorthAPI {

    @POST
    @Path("/operations/sptn-fm-module:query-alarms")
    @Produces({MediaType.APPLICATION_XML})
    Response queryAlarms(CurrentAlarmQueryCond request);

}
