package com.gwtt.ems.cmnb.model.north.tunnel;

import com.gwtt.ems.cmnb.model.common.NeId;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/20
 */

@XmlRootElement(name = "input")
public class RequestMegidSpacesInput {

    @XmlElementWrapper(name = "ne-ids")
    @XmlElement(name = "ne-id-list")
    List<NeId> neIdList;

    public List<NeId> getNeIdList() {
        return neIdList;
    }

    public void setNeIdList(List<NeId> neIdList) {
        this.neIdList = neIdList;
    }
}
