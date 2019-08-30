package com.gwtt.ems.cmnb.websocket.listener;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.gwtt.ems.cmnb.model.north.notification.UserChannel;
import com.gwtt.ems.cmnb.util.CmnbLogger;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * {@link ListenerAdapter} is responsible to track events, which occurred by
 * changing data in data source.
 */
public abstract class ListenerAdapter {

    private final String listenerId;
    //key channel
    private Map<Channel, UserChannel> subscribersMap = Collections.synchronizedMap(new ConcurrentHashMap<Channel, UserChannel>());
    private final EventBus eventBus;
    private final EventBusChangeRecorder eventBusChangeRecorder;

    public ListenerAdapter(String streamName) {
        Preconditions.checkArgument(streamName != null && !streamName.isEmpty());
        this.listenerId = streamName;
        eventBus = new AsyncEventBus(Executors.newSingleThreadExecutor());
        eventBusChangeRecorder = new EventBusChangeRecorder();
        eventBus.register(eventBusChangeRecorder);
    }

    public void sendEvent(String message) {
        final Event event = new Event(EventType.NOTIFY);
        event.setData(message);
        eventBus.post(event);
    }

    public String getListenerId() {
        return listenerId;
    }

    public void close() throws Exception {
        subscribersMap = Collections.synchronizedMap(new ConcurrentHashMap<Channel, UserChannel>());
        eventBus.unregister(eventBusChangeRecorder);
    }

    public void addSubscriber(final UserChannel subscriber) {
        if (!subscriber.getChannel().isActive()) {
            CmnbLogger.CMNBOUT.log("Channel is not active between websocket server and subscriber {}" + subscriber.getChannel().remoteAddress(), 3);
        }
        final Event event = new Event(EventType.REGISTER);
        event.setSubscriber(subscriber);
        eventBus.post(event);
    }

    public synchronized void removeSubscriber(final Channel subscriberCh) {
        CmnbLogger.CMNBOUT.log("Subscriber {} is removed." + subscriberCh.remoteAddress(), 3);
        UserChannel userChannel = subscribersMap.get(subscriberCh);
        if (userChannel == null) {
            CmnbLogger.CMNBOUT.log("Subscriber {} is null." + subscriberCh.remoteAddress(), 3);

        } else {
            final Event event = new Event(EventType.DEREGISTER);
            event.setSubscriber(userChannel);
            eventBus.post(event);
        }
    }

    public boolean hasSubscribers() {
        return !subscribersMap.isEmpty();
    }

    private final class EventBusChangeRecorder {

        @Subscribe
        public void recordCustomerChange(final Event event) {
            if (event == null) {
                return;
            }
            EventType eventType = event.getType();
            switch (eventType) {
                case REGISTER:
                    final UserChannel subscriber = event.getSubscriber();
                    if (!subscribersMap.values().contains(subscriber)) {

                        subscribersMap.put(subscriber.getChannel(), subscriber);

                        CmnbLogger.CMNBOUT.log("REGISTER chanel" + subscriber.getUriId() + " " + subscriber.getChannel().toString(), 3);
                    }
                    break;
                case DEREGISTER:
                    UserChannel c = null;
                    try {
                        if (event.getSubscriber() != null && event.getSubscriber().getChannel() != null) {
                            c = subscribersMap.remove(event.getSubscriber().getChannel());
                        }
                    } catch (Exception ex) {
                        CmnbLogger.CMNBERR.logException(ex, 3);
                    }
                    if (c == null) {
                        CmnbLogger.CMNBOUT.log("DEREGISTER c=null" + event.getSubscriber().getUriId(), 3);
                    } else {
                        CmnbLogger.CMNBOUT.log("DEREGISTER chanel" + c.getUriId() + " " + c.getChannel().toString(), 3);
                    }

                    break;
                case NOTIFY:

                    for (final UserChannel userChannel : subscribersMap.values()) {

                        Channel channel = userChannel.getChannel();
                        if (channel.isActive()) {
                            CmnbLogger.CMNBOUT.log("Data are sent to subscriber {}:" + channel.remoteAddress(), 3);
                            //不在这里进行权限校验，在触发前检查
//                            if (checkAuth(userChannel.getUser(), event)) {

                            channel.writeAndFlush(new TextWebSocketFrame(event.getData()));
//                            }
                        } else {
                            CmnbLogger.CMNBOUT.log("Subscriber {} is removed - channel is not active yet." + channel.remoteAddress(), 3);
                            subscribersMap.remove(channel);
                        }
                    }
            }
        }
    }

    private boolean checkAuth(String user, Event event) {
        boolean auth = false;
        //test
        if (user.equals("root")) {
            return true;
        }

        return auth;

    }

    class Event {

        private final EventType type;
        private UserChannel subscriber;
        private String data;

        /**
         * Creates new event specified by {@link EventType} type.
         *
         * @param type EventType
         */
        public Event(final EventType type) {
            this.type = type;
        }

        /**
         * Gets the {@link Channel} subscriber.
         *
         * @return Channel
         */
        public UserChannel getSubscriber() {
            return subscriber;
        }

        /**
         * Sets subscriber for event.
         *
         * @param subscriber Channel
         */
        public void setSubscriber(final UserChannel subscriber) {
            this.subscriber = subscriber;
        }

        /**
         * Gets event String.
         *
         * @return String representation of event data.
         */
        public String getData() {
            return data;
        }

        /**
         * Sets event data.
         *
         * @param data String.
         */
        public void setData(final String data) {
            this.data = data;
        }

        /**
         * Gets event type.
         *
         * @return The type of the event.
         */
        public EventType getType() {
            return type;
        }
    }

    enum EventType {

        REGISTER,
        DEREGISTER,
        NOTIFY;
    }
}
