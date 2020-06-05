package com.gwtt.ems.cmnb.model.north.route;


import com.gwtt.ems.cmnb.model.common.CalculateConstraint;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/19
 */
public class RerouteCalReqContainer {
    private String sequenceNo;

    /**
     * 0:lsp   1:pw，填写lsp或pw
     */
    private String layerRate;

    private String lspid;

    private LeftNeIds leftNeId;

    private RightNeIds rightNeIds;

    private CalculateConstraint calculateConstraint;

    public String getSequenceNo() {
        return sequenceNo;
    }

    @XmlElement(name = "sequence-no")
    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getLayerRate() {
        return layerRate;
    }

    @XmlElement(name = "layer-rate")
    public void setLayerRate(String layerRate) {
        this.layerRate = layerRate;
    }

    public String getLspid() {
        return lspid;
    }

    public void setLspid(String lspid) {
        this.lspid = lspid;
    }

    public LeftNeIds getLeftNeId() {
        return leftNeId;
    }

    @XmlElement(name = "left-ne-ids")
    public void setLeftNeId(LeftNeIds leftNeId) {
        this.leftNeId = leftNeId;
    }

    public RightNeIds getRightNeIds() {
        return rightNeIds;
    }

    @XmlElement(name = "right-ne-ids")
    public void setRightNeIds(RightNeIds rightNeIds) {
        this.rightNeIds = rightNeIds;
    }

    public CalculateConstraint getCalculateConstraint() {
        return calculateConstraint;
    }

    @XmlElement(name = "calculate-constraint")
    public void setCalculateConstraint(CalculateConstraint calculateConstraint) {
        this.calculateConstraint = calculateConstraint;
    }
}
