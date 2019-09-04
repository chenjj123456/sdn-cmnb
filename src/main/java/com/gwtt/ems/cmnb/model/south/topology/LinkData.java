package com.gwtt.ems.cmnb.model.south.topology;

import com.gwtt.ems.cmnb.model.common.*;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

/**
 * Created by chenjj on 2019/9/4
 */
public class LinkData extends EmsBaseData {

    private String id;
    private String name;

    private String userLabel;

    private LayerRate layerRate;

    private String parentTopoId;

    private Direction direction;

    private ExtLinkType extLinkType;

    private AdminStatus adminStatus;

    private OperateStatus operateStatus;

    private String leftNodeId;

    private String leftLtpId;

    private String rightNodeId;

    private String rightLtpId;

    private Long latency;

    private Long maxReservableBandwidth;

    private Long physicalBandwidth;

    private Long availableBandwidth;

    private Long linkLatency;

    private String leftLtpMac;

    private String rightLtpMac;

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

    public String getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public LayerRate getLayerRate() {
        return layerRate;
    }

    public void setLayerRate(LayerRate layerRate) {
        this.layerRate = layerRate;
    }

    public String getParentTopoId() {
        return parentTopoId;
    }

    public void setParentTopoId(String parentTopoId) {
        this.parentTopoId = parentTopoId;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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

    public String getLeftNodeId() {
        return leftNodeId;
    }

    public void setLeftNodeId(String leftNodeId) {
        this.leftNodeId = leftNodeId;
    }

    public String getLeftLtpId() {
        return leftLtpId;
    }

    public void setLeftLtpId(String leftLtpId) {
        this.leftLtpId = leftLtpId;
    }

    public String getRightNodeId() {
        return rightNodeId;
    }

    public void setRightNodeId(String rightNodeId) {
        this.rightNodeId = rightNodeId;
    }

    public String getRightLtpId() {
        return rightLtpId;
    }

    public void setRightLtpId(String rightLtpId) {
        this.rightLtpId = rightLtpId;
    }

    public Long getLatency() {
        return latency;
    }

    public void setLatency(Long latency) {
        this.latency = latency;
    }

    public Long getMaxReservableBandwidth() {
        return maxReservableBandwidth;
    }

    public void setMaxReservableBandwidth(Long maxReservableBandwidth) {
        this.maxReservableBandwidth = maxReservableBandwidth;
    }

    public Long getPhysicalBandwidth() {
        return physicalBandwidth;
    }

    public void setPhysicalBandwidth(Long physicalBandwidth) {
        this.physicalBandwidth = physicalBandwidth;
    }

    public Long getAvailableBandwidth() {
        return availableBandwidth;
    }

    public void setAvailableBandwidth(Long availableBandwidth) {
        this.availableBandwidth = availableBandwidth;
    }

    public Long getLinkLatency() {
        return linkLatency;
    }

    public void setLinkLatency(Long linkLatency) {
        this.linkLatency = linkLatency;
    }

    public ExtLinkType getExtLinkType() {
        return extLinkType;
    }

    public void setExtLinkType(ExtLinkType extLinkType) {
        this.extLinkType = extLinkType;
    }

    public String getLeftLtpMac() {
        return leftLtpMac;
    }

    public void setLeftLtpMac(String leftLtpMac) {
        this.leftLtpMac = leftLtpMac;
    }

    public String getRightLtpMac() {
        return rightLtpMac;
    }

    public void setRightLtpMac(String rightLtpMac) {
        this.rightLtpMac = rightLtpMac;
    }
}
