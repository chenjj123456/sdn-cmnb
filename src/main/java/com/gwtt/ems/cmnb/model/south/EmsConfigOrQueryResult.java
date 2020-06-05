package com.gwtt.ems.cmnb.model.south;


import com.gwtt.ems.cmnb.model.common.ConfigOrQueryResult;

/**
 * Created by chenjj on 2019/8/14
 */
public class EmsConfigOrQueryResult extends EmsBaseData {
    private ConfigOrQueryResult result;
    //查询结果
    private Object value;

    public ConfigOrQueryResult getResult() {
        return result;
    }

    public void setResult(ConfigOrQueryResult result) {
        this.result = result;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
