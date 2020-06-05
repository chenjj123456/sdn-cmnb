package com.gwtt.ems.cmnb.model.south.tunnel;

import com.gwtt.ems.cmnb.model.south.route.SncRouteData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/17
 */
public class CreateTunnelInputData {

    private SncTunnelData sncTunnelData;

    //路由数据一起下发
    private List<SncRouteData> sncRouteDataList;

    public SncTunnelData getSncTunnelData() {
        return sncTunnelData;
    }

    public void setSncTunnelData(SncTunnelData sncTunnelData) {
        this.sncTunnelData = sncTunnelData;
    }

    public List<SncRouteData> getSncRouteDataList() {
        return sncRouteDataList;
    }

    public void setSncRouteDataList(List<SncRouteData> sncRouteDataList) {
        this.sncRouteDataList = sncRouteDataList;
    }
}
