package com.gwtt.ems.cmnb.websocket.listener;

import com.gwtt.ems.cmnb.model.north.notification.UserChannel;
import com.gwtt.ems.cmnb.util.CmnbLogger;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Notificator {

    private static final Lock LOCK = new ReentrantLock();

    private Map<String, ListenerAdapter> listeners = Collections.synchronizedMap(new ConcurrentHashMap<>());

    private Notificator() {
    }
    private static Notificator instance;

    public static Notificator getInstance() {
        if (instance == null) {
            instance = new Notificator();
        }
        return instance;
    }

    public Set<String> getListenerIds() {
        return listeners.keySet();
    }

    public ListenerAdapter getListenerFor(String id) {
        return listeners.get(id);
    }


    public boolean existListenerFor(String id) {
        return listeners.containsKey(id);
    }

    public ListenerAdapter addListener(ListenerAdapter listener) {
        try {
            LOCK.lock();
            listeners.put(listener.getListenerId(), listener);
        } finally {
            LOCK.unlock();
        }
        return listener;
    }

    private String createIdFromUri(String uri) {

        String result = uri;
        if (result.startsWith("/")) {
            result = result.substring(1);
        }
        if (result.endsWith("/")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;

    }


    public String createListenerIdFromUri(String uri) {
        if (uri == null) {
            return null;
        }
        CmnbLogger.CMNBOUT.log("uri:" + uri, 3);;
        String result = "";
        try {

            result = createIdFromUri(uri);

            if (result.contains("/")) {
                result = result.substring(0, result.lastIndexOf("/"));
            }
        } catch (Exception ex) {
        }
        CmnbLogger.CMNBOUT.log("id:" + result, 3);
        return result;
    }

    public String createUserIdFromUri(String uri) {
        if (uri == null) {
            return null;
        }
        String result = createIdFromUri(uri);
        result = result.substring(result.lastIndexOf("/") + 1);
        result = result.substring(result.indexOf(":") + 1);
        return result;

    }

    public static UserChannel createUserChannelFromUri(String uri) {
        UserChannel result = new UserChannel();
        if (uri.startsWith("/")) {
            uri = uri.substring(1);
        }
        String[] info = uri.split("/");
        String channelType = info[0];
        String version = info[1];
        String info2 = info[2];
        String user = info2.substring(info2.indexOf(":") + 1);

        result.setChannelType(channelType);
        result.setVersion(version);
        result.setUser(user);

        return result;
    }

    public void removeAllListeners() {
        for (ListenerAdapter listener : listeners.values()) {
            try {
                listener.close();
            } catch (Exception e) {
            }
        }
        try {
            LOCK.lock();
            listeners = Collections.synchronizedMap(new ConcurrentHashMap<String,ListenerAdapter>());
        } finally {
            LOCK.unlock();
        }
    }

    public void removeListenerIfNoSubscriberExists(ListenerAdapter listener) {
        if (!listener.hasSubscribers()) {
            deleteListener(listener);
        }
    }

    private void deleteListener(ListenerAdapter listener) {
        if (listener != null) {
            try {
                listener.close();
            } catch (Exception e) {
            }
            try {
                LOCK.lock();
                listeners.remove(listener.getListenerId());
            } finally {
                LOCK.unlock();
            }
        }
    }
}
