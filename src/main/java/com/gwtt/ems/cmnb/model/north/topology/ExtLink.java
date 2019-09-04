package com.gwtt.ems.cmnb.model.north.topology;

import com.gwtt.ems.cmnb.model.common.*;
import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/4
 */
public class ExtLink extends CmnbBaseData {

    private String name;

    @XmlElement(name = "user-label")
    private String userLabel;

    @XmlElement(name = "layer-rate")
    private LayerRate layerRate;

    @XmlElement(name = "parent-topo-id")
    private String parentTopoId;

    private Direction direction;

    @XmlElement(name = "ext-link-type")
    private ExtLinkType extLinkType;

    @XmlElement(name = "admin-status")
    private AdminStatus adminStatus;

    @XmlElement(name = "operate-status")
    private OperateStatus operateStatus;

    @XmlElement(name = "left-node-id")
    private String leftNodeId;

    @XmlElement(name = "left-ltp-id")
    private String leftLtpId;

    @XmlElement(name = "right-node-id")
    private String rightNodeId;

    @XmlElement(name = "right-ltp-id")
    private String rightLtpId;

    @XmlElement(name = "link-te-attr-cfg")
    private LinkTeAttrCfg linkTeAttrCfg;

    @XmlElement(name = "link-te-attr-run")
    private LinkTeAttrRun linkTeAttrRun;

    @XmlElement(name = "left-ltp-mac")
    private String leftLtpMac;

    @XmlElement(name = "right-ltp-mac")
    private String rightLtpMac;

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

    public ExtLinkType getExtLinkType() {
        return extLinkType;
    }

    public void setExtLinkType(ExtLinkType extLinkType) {
        this.extLinkType = extLinkType;
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

    public LinkTeAttrCfg getLinkTeAttrCfg() {
        return linkTeAttrCfg;
    }

    public void setLinkTeAttrCfg(LinkTeAttrCfg linkTeAttrCfg) {
        this.linkTeAttrCfg = linkTeAttrCfg;
    }

    public LinkTeAttrRun getLinkTeAttrRun() {
        return linkTeAttrRun;
    }

    public void setLinkTeAttrRun(LinkTeAttrRun linkTeAttrRun) {
        this.linkTeAttrRun = linkTeAttrRun;
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
