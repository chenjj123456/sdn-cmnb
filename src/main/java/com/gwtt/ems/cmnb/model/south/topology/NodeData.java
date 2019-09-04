package com.gwtt.ems.cmnb.model.south.topology;

import com.gwtt.ems.cmnb.model.common.AdminStatus;
import com.gwtt.ems.cmnb.model.common.NodeType;
import com.gwtt.ems.cmnb.model.common.OperateStatus;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

/**
 * Created by chenjj on 2019/9/4
 */
public class NodeData extends EmsBaseData {
    private String id;
    private String name;
    private String userLabel;
    private NodeType nodeType;
    private AdminStatus adminStatus;
    private OperateStatus operateStatus;
    private String parentTopoId;
    private String resourceId;

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
