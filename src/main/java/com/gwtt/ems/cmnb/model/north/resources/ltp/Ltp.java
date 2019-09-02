package com.gwtt.ems.cmnb.model.north.resources.ltp;

import com.gwtt.ems.cmnb.model.common.AdminStatus;
import com.gwtt.ems.cmnb.model.common.OperateStatus;
import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigInteger;

/**
 * Created by chenjj on 2019/7/24
 */
public class Ltp extends CmnbBaseData {

    @XmlElement(name = "user-label")
    private String userLabel;

    @XmlElement(name = "ne-id")
    private String neId;

    private String name;

    @XmlElement(name = "layer-rate")
    private Long LayerRate;

    @XmlElement(name = "ip-address")
    private String ipAddress;

    private String mtu;

    private BigInteger speed;

    @XmlElement(name = "admin-status")
    private AdminStatus adminStatus;

    @XmlElement(name = "operate-status")
    private OperateStatus operateStatus;

    @XmlElement(name = "mac-address")
    private String macAddress;


    public String getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public String getNeId() {
        return neId;
    }

    public void setNeId(String neId) {
        this.neId = neId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLayerRate() {
        return LayerRate;
    }

    public void setLayerRate(Long layerRate) {
        LayerRate = layerRate;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMtu() {
        return mtu;
    }

    public void setMtu(String mtu) {
        this.mtu = mtu;
    }

    public BigInteger getSpeed() {
        return speed;
    }

    public void setSpeed(BigInteger speed) {
        this.speed = speed;
    }

    public AdminStatus getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(AdminStatus adminStatus) {
        this.adminStatus = adminStatus;
    }

    public OperateStatus getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(OperateStatus operateStatus) {
        this.operateStatus = operateStatus;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
