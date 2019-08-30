package com.gwtt.ems.cmnb.model.north.notification;


import io.netty.channel.Channel;

/**
 * Created by chenjj on 2019/7/25
 */
public class UserChannel {
    public UserChannel() {
    }

    public String getUriId() {
        return channelType + "/" + version + "/user:" + user;
    }
    private String user;

    private Channel channel;

    private String version;

    private String channelType;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }
}
