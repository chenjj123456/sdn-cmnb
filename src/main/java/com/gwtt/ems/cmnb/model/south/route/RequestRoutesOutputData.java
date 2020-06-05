package com.gwtt.ems.cmnb.model.south.route;

import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/19
 */
public class RequestRoutesOutputData extends EmsBaseData {

    private List<RouteCalResultData> routeCalResultDataList;

    public List<RouteCalResultData> getRouteCalResultDataList() {
        return routeCalResultDataList;
    }

    public void setRouteCalResultDataList(List<RouteCalResultData> routeCalResultDataList) {
        this.routeCalResultDataList = routeCalResultDataList;
    }
}
