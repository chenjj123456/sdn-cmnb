package com.gwtt.ems.cmnb.model.south.route;

import com.gwtt.ems.cmnb.model.common.CalculateConstraint;
import com.gwtt.ems.cmnb.model.common.NeId;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/19
 */
public class RerouteCalReqData extends EmsBaseData {

    private String sequenceNo;

    /**
     * 0:lsp   1:pw，填写lsp或pw
     */
    private String layerRate;

    private String lspid;

    private List<NeId> leftNeId;

    private List<NeId> rightNeId;

    private CalculateConstraint calculateConstraint;

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getLayerRate() {
        return layerRate;
    }

    public void setLayerRate(String layerRate) {
        this.layerRate = layerRate;
    }

    public String getLspid() {
        return lspid;
    }

    public void setLspid(String lspid) {
        this.lspid = lspid;
    }

    public List<NeId> getLeftNeId() {
        return leftNeId;
    }

    public void setLeftNeId(List<NeId> leftNeId) {
        this.leftNeId = leftNeId;
    }

    public List<NeId> getRightNeId() {
        return rightNeId;
    }

    public void setRightNeId(List<NeId> rightNeId) {
        this.rightNeId = rightNeId;
    }

    public CalculateConstraint getCalculateConstraint() {
        return calculateConstraint;
    }

    public void setCalculateConstraint(CalculateConstraint calculateConstraint) {
        this.calculateConstraint = calculateConstraint;
    }
}
