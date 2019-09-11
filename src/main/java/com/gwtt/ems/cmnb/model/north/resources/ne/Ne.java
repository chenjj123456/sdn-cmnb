package com.gwtt.ems.cmnb.model.north.resources.ne;

import com.gwtt.ems.cmnb.model.common.AdminStatus;
import com.gwtt.ems.cmnb.model.common.OperateStatus;
import com.gwtt.ems.cmnb.model.north.CmnbBaseData;
import com.gwtt.ems.cmnb.model.north.resources.ltp.Ltp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/1
 */
@XmlRootElement(name = "ne")
public class Ne extends CmnbBaseData {
    private String name;

    private String type;

    @XmlElement(name = "user-label")
    private String userLabel;

    @XmlElement(name = "admin-ip")
    private String adminIp;

    @XmlElement(name = "admin-status")
    private AdminStatus adminStatus;

    @XmlElement(name = "operate-status")
    private OperateStatus operateStatus;

    /**
     * longitude of NE
     */
    private String longitude;

    /**
     * latitude of NE
     */
    private String latitude;

    private String location;

    private Long latency;

    @XmlElement(name = "vendor-name")
    private String vendorName;

    @XmlElementWrapper(name = "ltps")
    @XmlElement(name = "ltp")
    private List<Ltp> ltp;

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

    public List<Ltp> getLtp() {
        return ltp;
    }

    public void setLtp(List<Ltp> ltp) {
        this.ltp = ltp;
    }
}
