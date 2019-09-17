package com.gwtt.ems.cmnb.model.north.route;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenjj on 2019/9/17
 */
public class Xcs {
    private List<XcList> xcList;

    public List<XcList> getXcList() {
        return xcList;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement(name = "xc-list")
    public void setXcList(List<XcList> xcList) {
        this.xcList = xcList;
    }
}
