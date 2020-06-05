package com.gwtt.ems.cmnb.model.south.tunnel;

import com.gwtt.ems.cmnb.model.common.NeIdList;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/20
 */
public class RequestLabelsInputData extends EmsBaseData {

    private List<NeIdList> neIdLists;

    private Long labelNumber;

    public List<NeIdList> getNeIdLists() {
        return neIdLists;
    }

    public void setNeIdLists(List<NeIdList> neIdLists) {
        this.neIdLists = neIdLists;
    }

    public Long getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(Long labelNumber) {
        this.labelNumber = labelNumber;
    }
}
