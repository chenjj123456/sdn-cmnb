package com.gwtt.ems.cmnb.model.south.resources;

import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/1
 */
public class NeDataList extends EmsBaseData {
    private List<NeData> neDataList;

    public List<NeData> getNeDataList() {
        return neDataList;
    }

    public void setNeDataList(List<NeData> neDataList) {
        this.neDataList = neDataList;
    }
}
