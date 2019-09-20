package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by chenjj on 2019/9/20
 */
public class NeLabelList {

    private String neId;

    private List<LabelList> labelList;

    public String getNeId() {
        return neId;
    }

    @XmlElement(name = "ne-id")
    public void setNeId(String neId) {
        this.neId = neId;
    }

    public List<LabelList> getLabelList() {
        return labelList;
    }

    @XmlElementWrapper(name = "labels")
    @XmlElement(name = "label-list")
    public void setLabelList(List<LabelList> labelList) {
        this.labelList = labelList;
    }
}
