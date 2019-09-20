package com.gwtt.ems.cmnb.model.north.tunnel;

import com.gwtt.ems.cmnb.model.common.NeMegidSpace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/20
 */

@XmlRootElement(name = "output")
public class RequestMegidSpacesOutput {

    private List<NeMegidSpace> neMegidSpace;

    public List<NeMegidSpace> getNeMegidSpace() {
        return neMegidSpace;
    }

    @XmlElementWrapper(name = "ne-megid-spaces")
    @XmlElement(name = "ne-megid-space")
    public void setNeMegidSpace(List<NeMegidSpace> neMegidSpace) {
        this.neMegidSpace = neMegidSpace;
    }
}
