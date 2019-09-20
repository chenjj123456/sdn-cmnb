package com.gwtt.ems.cmnb.model.south.tunnel;

import com.gwtt.ems.cmnb.model.common.NeLabelList;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/20
 */
public class RequestLabelsOutputData extends EmsBaseData {
    private List<NeLabelList> neLabelLists;

    public List<NeLabelList> getNeLabelLists() {
        return neLabelLists;
    }

    public void setNeLabelLists(List<NeLabelList> neLabelLists) {
        this.neLabelLists = neLabelLists;
    }
}
