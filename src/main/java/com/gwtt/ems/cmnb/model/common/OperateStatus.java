package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/8/5
 */
public enum OperateStatus {
    @XmlElement(name = "operate-up")
    OperateUp,
    @XmlElement(name="operate-down")
    OperateDown
}
