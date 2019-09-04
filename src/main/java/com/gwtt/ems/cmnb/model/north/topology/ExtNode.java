package com.gwtt.ems.cmnb.model.north.topology;

import com.gwtt.ems.cmnb.model.common.AdminStatus;
import com.gwtt.ems.cmnb.model.common.NodeType;
import com.gwtt.ems.cmnb.model.common.OperateStatus;
import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/4
 */
public class ExtNode extends CmnbBaseData {
    private String name;

    @XmlElement(name = "user-label")
    private String userLabel;

    @XmlElement(name = "node-type")
    private NodeType nodeType;

    @XmlElement(name = "admin-status")
    private AdminStatus adminStatus;

    @XmlElement(name = "operate-status")
    private OperateStatus operateStatus;

    @XmlElement(name = "parent-topo-id")
    private String parentTopoId;

    @XmlElement(name = "resource-id")
    private String resourceId;

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

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
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

    public String getParentTopoId() {
        return parentTopoId;
    }

    public void setParentTopoId(String parentTopoId) {
        this.parentTopoId = parentTopoId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
