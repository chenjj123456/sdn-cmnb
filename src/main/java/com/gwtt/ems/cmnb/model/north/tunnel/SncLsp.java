package com.gwtt.ems.cmnb.model.north.tunnel;

import com.gwtt.ems.cmnb.model.common.*;
import com.gwtt.ems.cmnb.model.north.CmnbBaseData;

import javax.xml.bind.annotation.XmlElement;


/**
 * Created by chenjj on 2019/9/16
 */
public class SncLsp extends CmnbBaseData {

    private String name;

    private String userLabel;

    private Direction direction;

    private Role role;

    private Type type;

    private String ingressNeId;

    private String egressNeId;

    private LspConstraint lspConstraint;

    private AdminStatus adminStatus;

    private OperateStatus operateStatus;

    private Oam oam;

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

    @XmlElement(name = "ingress-ne-id")
    public void setIngressNeId(String ingressNeId) {
        this.ingressNeId = ingressNeId;
    }

    public String getEgressNeId() {
        return egressNeId;
    }

    @XmlElement(name = "egress-ne-id")
    public void setEgressNeId(String egressNeId) {
        this.egressNeId = egressNeId;
    }

    public LspConstraint getLspConstraint() {
        return lspConstraint;
    }

    @XmlElement(name = "lsp-constraint")
    public void setLspConstraint(LspConstraint lspConstraint) {
        this.lspConstraint = lspConstraint;
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

    public Oam getOam() {
        return oam;
    }

    public void setOam(Oam oam) {
        this.oam = oam;
    }
}
