package com.gwtt.ems.cmnb.northInterface.tunnel;

import com.gwtt.ems.cmnb.websocket.listener.ListenerAdapter;

/**
 * Created by chenjj on 2019/9/18
 */
public class SncLspListenerAdapter extends ListenerAdapter {
    public SncLspListenerAdapter() {
        super("snc-lsp-notification");
    }
}
