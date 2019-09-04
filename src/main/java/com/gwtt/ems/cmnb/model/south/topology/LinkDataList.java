package com.gwtt.ems.cmnb.model.south.topology;

import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/4
 */
public class LinkDataList extends EmsBaseData {
    private List<LinkData> linkDataList;

    public List<LinkData> getLinkDataList() {
        return linkDataList;
    }

    public void setLinkDataList(List<LinkData> linkDataList) {
        this.linkDataList = linkDataList;
    }
}
