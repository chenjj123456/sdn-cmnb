package com.gwtt.ems.cmnb.model.north.resources.ncd;

import com.gwtt.ems.cmnb.model.common.AdminStatus;
import com.gwtt.ems.cmnb.model.common.OperateStatus;
import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/7/24
 */
@XmlRootElement(name = "ncd")
public class Ncd extends CmnbBaseData {

    /**
     * NCD name generated by super controller
     */
    private String name;

    /**
     * NCD UserLabel
     */
    @XmlElement(name = "user-label")
    private String userLabel;

    /**
     * Direct father control domain id
     */
    @XmlElement(name = "parent-ncd-id")
    private String parentNcdId;

    /**
     * Location of the working controller
     */
    @XmlElement(name = "active-controller-location")
    private String activeControllerLocation;

    @XmlElement(name = "vendor-name")
    private String vendorName;

    /**
     * IP of working controller
     */
    @XmlElement(name = "active-controller-ip")
    private String activeControllerIp;

    /**
     * PORT of working controller
     */
    private Long port;

    @XmlElement(name = "admin-status")
    private AdminStatus adminStatus;

    @XmlElement(name = "operate-status")
    private OperateStatus operateStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public String getParentNcdId() {
        return parentNcdId;
    }

    public void setParentNcdId(String parentNcdId) {
        this.parentNcdId = parentNcdId;
    }

    public String getActiveControllerLocation() {
        return activeControllerLocation;
    }

    public void setActiveControllerLocation(String activeControllerLocation) {
        this.activeControllerLocation = activeControllerLocation;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getActiveControllerIp() {
        return activeControllerIp;
    }

    public void setActiveControllerIp(String activeControllerIp) {
        this.activeControllerIp = activeControllerIp;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
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
}
