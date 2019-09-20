package com.gwtt.ems.cmnb.model.north.tunnel;

import com.gwtt.ems.cmnb.model.common.NeLabelList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/20
 */

@XmlRootElement(name = "output")
public class RequestLabelsOutput {

    private List<NeLabelList> neLabelList;

    public List<NeLabelList> getNeLabelList() {
        return neLabelList;
    }

    @XmlElementWrapper(name = "ne-labels")
    @XmlElement(name = "ne-label-list")
    public void setNeLabelList(List<NeLabelList> neLabelList) {
        this.neLabelList = neLabelList;
    }
}
