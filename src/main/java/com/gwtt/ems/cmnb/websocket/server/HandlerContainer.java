package com.gwtt.ems.cmnb.websocket.server;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HandlerContainer {

    private static final Lock LOCK = new ReentrantLock();
    private static final Map<WebSocketServerHandler, String> HANDLER_MAP = Collections.synchronizedMap(new ConcurrentHashMap<WebSocketServerHandler, String>());

    public static void removeAllHandler() {
        try {
            LOCK.lock();
            HANDLER_MAP.clear();
        } finally {
            LOCK.unlock();
        }
    }

    public static void addHandler(WebSocketServerHandler handler, String channelId) {
        try {
            LOCK.lock();
            HANDLER_MAP.put(handler, channelId);
        } finally {
            LOCK.unlock();
        }
    }

    public static void removeHandler(WebSocketServerHandler handler) {
        try {
            HANDLER_MAP.remove(handler);
        } finally {
            LOCK.unlock();
        }
    }

    public static String getHandlerId(WebSocketServerHandler handler) {
        return HANDLER_MAP.get(handler);
    }
}

