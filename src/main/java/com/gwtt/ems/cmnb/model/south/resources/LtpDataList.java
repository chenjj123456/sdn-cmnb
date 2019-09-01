package com.gwtt.ems.cmnb.model.south.resources;

import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/1
 */
public class LtpDataList extends EmsBaseData {
    List<LtpData> ltpDataList;

    public List<LtpData> getLtpDataList() {
        return ltpDataList;
    }

    public void setLtpDataList(List<LtpData> ltpDataList) {
        this.ltpDataList = ltpDataList;
    }
}
