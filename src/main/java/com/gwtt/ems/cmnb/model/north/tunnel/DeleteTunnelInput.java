package com.gwtt.ems.cmnb.model.north.tunnel;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/9/17
 */
@XmlRootElement(name = "input")
public class DeleteTunnelInput {

    private String tunnelId;

    public String getTunnelId() {
        return tunnelId;
    }

    @XmlElement(name = "tunnel-id")
    public void setTunnelId(String tunnelId) {
        this.tunnelId = tunnelId;
    }
}
