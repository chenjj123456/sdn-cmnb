package com.gwtt.ems.cmnb.model.south.resources;

import com.gwtt.ems.cmnb.model.common.AdminStatus;
import com.gwtt.ems.cmnb.model.common.OperateStatus;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/1
 */
public class NeData extends EmsBaseData {
    // uuid of ne
    private String id;

    //eg:192.168.10.63
    private String name;

    //eg:7600S/710A
    private String type;

    //eg:192.168.10.63
    private String userLabel;

    //eg:192.168.10.63
    private String adminIp;

    private AdminStatus adminStatus;

    private OperateStatus operateStatus;

    private String longitude;

    private String latitude;

    private String location;

    private Long latency;

    private String vendorName;

    private List<LtpData> ltpDataList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public String getAdminIp() {
        return adminIp;
    }

    public void setAdminIp(String adminIp) {
        this.adminIp = adminIp;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getLatency() {
        return latency;
    }

    public void setLatency(Long latency) {
        this.latency = latency;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public List<LtpData> getLtpDataList() {
        return ltpDataList;
    }

    public void setLtpDataList(List<LtpData> ltpDataList) {
        this.ltpDataList = ltpDataList;
    }
}
