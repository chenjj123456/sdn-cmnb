package com.gwtt.ems.cmnb.model.south.tunnel;

import com.gwtt.ems.cmnb.model.south.EmsBaseData;

/**
 * Created by chenjj on 2019/9/17
 */
public class MepData extends EmsBaseData {

    private String name;

    /**
     * id of mep.
     * range "1 | 2"
     */
    private Byte Id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getId() {
        return Id;
    }

    public void setId(Byte id) {
        Id = id;
    }
}
