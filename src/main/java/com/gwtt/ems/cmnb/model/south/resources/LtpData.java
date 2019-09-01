package com.gwtt.ems.cmnb.model.south.resources;

import com.gwtt.ems.cmnb.model.common.AdminStatus;
import com.gwtt.ems.cmnb.model.common.OperateStatus;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.math.BigInteger;

/**
 * Created by chenjj on 2019/9/1
 */
public class LtpData extends EmsBaseData {
    // uuid of ltp
    private String id;

    //eg:port1/1
    private String userlabel;

    // uuid of ne
    private String neId;

    //eg:openflow:68336848694:14
    private String name;

    private Long layerRate;

    private String ipAddress;

    private String mtu;

    private BigInteger speed;

    private AdminStatus adminStatus;

    private OperateStatus operateStatus;

    private String macAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserlabel() {
        return userlabel;
    }

    public void setUserlabel(String userlabel) {
        this.userlabel = userlabel;
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
        return layerRate;
    }

    public void setLayerRate(Long layerRate) {
        this.layerRate = layerRate;
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
