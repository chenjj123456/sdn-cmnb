package com.gwtt.ems.cmnb.model.south.tunnel;

import com.gwtt.ems.cmnb.model.common.NeMegidSpace;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

import java.util.List;

/**
 * Created by chenjj on 2019/9/20
 */
public class RequestMegidSpacesOutputData extends EmsBaseData {

    private List<NeMegidSpace> neMegidSpaces;

    public List<NeMegidSpace> getNeMegidSpaces() {
        return neMegidSpaces;
    }

    public void setNeMegidSpaces(List<NeMegidSpace> neMegidSpaces) {
        this.neMegidSpaces = neMegidSpaces;
    }
}
