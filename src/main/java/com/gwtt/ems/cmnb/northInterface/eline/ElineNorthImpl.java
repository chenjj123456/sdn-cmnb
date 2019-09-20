package com.gwtt.ems.cmnb.northInterface.eline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

/**
 * Created by chenjj on 2019/9/20
 */

@Component
public class ElineNorthImpl implements ElineNorthAPI {
    private static final Logger LOG = LoggerFactory.getLogger(ElineNorthImpl.class);

    @Override
    public Response getAllSncElines(int dep, String ncdId) {
        LOG.info("getAllSncTunnels:{},{}",dep,ncdId);

        return null;
    }
}
