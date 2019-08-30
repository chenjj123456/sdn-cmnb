package com.gwtt.ems.cmnb.northInterface.fm;


import com.gwtt.ems.cmnb.websocket.listener.ListenerAdapter;

/**
 * Created by chenjj on 2019/8/1
 */
public class AlarmListenerAdapter extends ListenerAdapter {
    public AlarmListenerAdapter() {
        super("alarms-notification");
    }
}
