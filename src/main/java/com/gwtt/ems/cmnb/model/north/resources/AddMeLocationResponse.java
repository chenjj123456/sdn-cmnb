package com.gwtt.ems.cmnb.model.north.resources;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/7/25
 */

@XmlRootElement(name = "output")
public class AddMeLocationResponse{
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
