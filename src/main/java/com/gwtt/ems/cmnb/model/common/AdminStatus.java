package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/8/5
 */
public enum AdminStatus {
    @XmlElement(name = "admin-up")
    adminUp,
    @XmlElement(name = "admin-down")
    adminDown
}
