package com.gwtt.ems.cmnb.northInterface.tunnel;

import com.gwtt.ems.cmnb.websocket.listener.ListenerAdapter;

/**
 * Created by chenjj on 2019/9/18
 */
public class SncTunnelListenerAdapter extends ListenerAdapter {
    public SncTunnelListenerAdapter() {
        super("snc-tunnel-notification");
    }
}
