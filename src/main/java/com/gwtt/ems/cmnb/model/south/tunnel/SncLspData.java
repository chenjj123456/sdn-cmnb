package com.gwtt.ems.cmnb.model.south.tunnel;

import com.gwtt.ems.cmnb.model.common.*;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/17
 */
public class SncLspData extends EmsBaseData {
    private String uuid;

    private String name;

    private String userLabel;

    private Direction direction;

    private Role role;

    private Type type;

    private String ingressNeId;

    private String egressNeId;

    private List<String> explicitIncludeNes;

    private List<String> explicitIncludeLinks;

    private List<String> explicitExcludeNes;

    private List<String> explicitExcludeLinks;

    private AdminStatus adminStatus;

    private OperateStatus operateStatus;

    private OamData oam;

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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getIngressNeId() {
        return ingressNeId;
    }

    public void setIngressNeId(String ingressNeId) {
        this.ingressNeId = ingressNeId;
    }

    public String getEgressNeId() {
        return egressNeId;
    }

    public void setEgressNeId(String egressNeId) {
        this.egressNeId = egressNeId;
    }

    public List<String> getExplicitIncludeNes() {
        return explicitIncludeNes;
    }

    public void setExplicitIncludeNes(List<String> explicitIncludeNes) {
        this.explicitIncludeNes = explicitIncludeNes;
    }

    public List<String> getExplicitIncludeLinks() {
        return explicitIncludeLinks;
    }

    public void setExplicitIncludeLinks(List<String> explicitIncludeLinks) {
        this.explicitIncludeLinks = explicitIncludeLinks;
    }

    public List<String> getExplicitExcludeNes() {
        return explicitExcludeNes;
    }

    public void setExplicitExcludeNes(List<String> explicitExcludeNes) {
        this.explicitExcludeNes = explicitExcludeNes;
    }

    public List<String> getExplicitExcludeLinks() {
        return explicitExcludeLinks;
    }

    public void setExplicitExcludeLinks(List<String> explicitExcludeLinks) {
        this.explicitExcludeLinks = explicitExcludeLinks;
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

    public OamData getOam() {
        return oam;
    }

    public void setOam(OamData oam) {
        this.oam = oam;
    }
}
