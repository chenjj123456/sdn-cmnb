package com.gwtt.ems.cmnb.model.north.tunnel;

import com.gwtt.ems.cmnb.model.common.AdminStatus;
import com.gwtt.ems.cmnb.model.common.Direction;
import com.gwtt.ems.cmnb.model.common.OperateStatus;
import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by chenjj on 2019/9/16
 */
public class SncTunnel extends CmnbBaseData {

    private String name;

    private String userLabel;

    private String tenantId;

    private String creater;

    private String parentNcdId;

    private Direction direction;

    /**
     * type of snc tunnel.
     * 1 is line MPLS,
     * 2 is ring MPLS.
     */
    private int type;

    private String sourceNeId;

    private String destinationNeId;

    private String sourceIp;

    private String destinationIp;

    private Qos qos;

    private SncSwitch sncSwitch;

    private List<SncLsp> sncLsp;

    private AdminStatus adminStatus;

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

    @XmlElement(name = "user-label")
    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public String getTenantId() {
        return tenantId;
    }

    @XmlElement(name = "tenant-id")
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getParentNcdId() {
        return parentNcdId;
    }

    @XmlElement(name = "parent-ncd-id")
    public void setParentNcdId(String parentNcdId) {
        this.parentNcdId = parentNcdId;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSourceNeId() {
        return sourceNeId;
    }

    @XmlElement(name = "source-ne-id")
    public void setSourceNeId(String sourceNeId) {
        this.sourceNeId = sourceNeId;
    }

    public String getDestinationNeId() {
        return destinationNeId;
    }

    @XmlElement(name = "destination-ne-id")
    public void setDestinationNeId(String destinationNeId) {
        this.destinationNeId = destinationNeId;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    @XmlElement(name = "source-ip")
    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getDestinationIp() {
        return destinationIp;
    }

    @XmlElement(name = "destination-ip")
    public void setDestinationIp(String destinationIp) {
        this.destinationIp = destinationIp;
    }

    public Qos getQos() {
        return qos;
    }

    public void setQos(Qos qos) {
        this.qos = qos;
    }

    public SncSwitch getSncSwitch() {
        return sncSwitch;
    }

    @XmlElement(name = "snc-switch")
    public void setSncSwitch(SncSwitch sncSwitch) {
        this.sncSwitch = sncSwitch;
    }

    public List<SncLsp> getSncLsp() {
        return sncLsp;
    }

    @XmlElementWrapper(name = "snc-lsps")
    @XmlElement(name = "snc-lsp")
    public void setSncLsp(List<SncLsp> sncLsp) {
        this.sncLsp = sncLsp;
    }

    public AdminStatus getAdminStatus() {
        return adminStatus;
    }

    @XmlElement(name = "admin-status")
    public void setAdminStatus(AdminStatus adminStatus) {
        this.adminStatus = adminStatus;
    }

    public OperateStatus getOperateStatus() {
        return operateStatus;
    }

    @XmlElement(name = "operate-status")
    public void setOperateStatus(OperateStatus operateStatus) {
        this.operateStatus = operateStatus;
    }
}
