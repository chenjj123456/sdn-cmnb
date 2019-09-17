package com.gwtt.ems.cmnb.model.south.tunnel;

import com.gwtt.ems.cmnb.model.common.AdminStatus;
import com.gwtt.ems.cmnb.model.common.Direction;
import com.gwtt.ems.cmnb.model.common.OperateStatus;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/17
 */
public class SncTunnelData extends EmsBaseData {
    private String uuid;

    private String name;

    private String userLabel;

    private String tenantId;

    private String creater;

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

    private QosData qos;

    private SncSwitchData sncSwitch;

    private List<SncLspData> sncLsp;

    private AdminStatus adminStatus;

    private OperateStatus operateStatus;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
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

    public void setSourceNeId(String sourceNeId) {
        this.sourceNeId = sourceNeId;
    }

    public String getDestinationNeId() {
        return destinationNeId;
    }

    public void setDestinationNeId(String destinationNeId) {
        this.destinationNeId = destinationNeId;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getDestinationIp() {
        return destinationIp;
    }

    public void setDestinationIp(String destinationIp) {
        this.destinationIp = destinationIp;
    }

    public QosData getQos() {
        return qos;
    }

    public void setQos(QosData qos) {
        this.qos = qos;
    }

    public SncSwitchData getSncSwitch() {
        return sncSwitch;
    }

    public void setSncSwitch(SncSwitchData sncSwitch) {
        this.sncSwitch = sncSwitch;
    }

    public List<SncLspData> getSncLsp() {
        return sncLsp;
    }

    public void setSncLsp(List<SncLspData> sncLsp) {
        this.sncLsp = sncLsp;
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
