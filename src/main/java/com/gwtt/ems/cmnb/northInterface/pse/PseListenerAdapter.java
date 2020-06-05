package com.gwtt.ems.cmnb.northInterface.pse;

import com.gwtt.ems.cmnb.websocket.listener.ListenerAdapter;

/**
 * Created by chenjj on 2019/9/19
 */
public class PseListenerAdapter extends ListenerAdapter {
    public PseListenerAdapter() {
        super("pses-notification");
    }
}
