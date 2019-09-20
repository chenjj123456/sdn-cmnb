package com.gwtt.ems.cmnb.model.south.route;

import com.gwtt.ems.cmnb.model.common.Role;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/19
 */
public class RouteCalResultData extends EmsBaseData {
    private String sequenceNo;

    private String groupNo;

    private Role role;

    private String ingressNeId;

    private String egressNeId;

    /**
     * Latency. unit:ns
     * range "0..60000000"
     */
    private Long latency;

    /**
     * max availble bandwidth. unit:kbps
     * range "0..4000000000"
     */
    private Long maxAvailbleBandwidth;

    private List<XcData> xcDataList;

    private String sharedTunnelId;

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public Long getLatency() {
        return latency;
    }

    public void setLatency(Long latency) {
        this.latency = latency;
    }

    public Long getMaxAvailbleBandwidth() {
        return maxAvailbleBandwidth;
    }

    public void setMaxAvailbleBandwidth(Long maxAvailbleBandwidth) {
        this.maxAvailbleBandwidth = maxAvailbleBandwidth;
    }

    public List<XcData> getXcDataList() {
        return xcDataList;
    }

    public void setXcDataList(List<XcData> xcDataList) {
        this.xcDataList = xcDataList;
    }

    public String getSharedTunnelId() {
        return sharedTunnelId;
    }

    public void setSharedTunnelId(String sharedTunnelId) {
        this.sharedTunnelId = sharedTunnelId;
    }
}
