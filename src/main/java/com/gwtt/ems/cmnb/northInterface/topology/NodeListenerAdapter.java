package com.gwtt.ems.cmnb.northInterface.topology;

import com.gwtt.ems.cmnb.websocket.listener.ListenerAdapter;

/**
 * Created by chenjj on 2019/9/5
 */
public class NodeListenerAdapter extends ListenerAdapter {
    public NodeListenerAdapter() {
        super("node-notification");
    }
}
