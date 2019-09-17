package com.gwtt.ems.cmnb.model.south.tunnel;

import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/17
 */
public class SncTunnelDataList extends EmsBaseData {

    private List<SncTunnelData> sncTunnelDataList;

    public List<SncTunnelData> getSncTunnelDataList() {
        return sncTunnelDataList;
    }

    public void setSncTunnelDataList(List<SncTunnelData> sncTunnelDataList) {
        this.sncTunnelDataList = sncTunnelDataList;
    }
}
