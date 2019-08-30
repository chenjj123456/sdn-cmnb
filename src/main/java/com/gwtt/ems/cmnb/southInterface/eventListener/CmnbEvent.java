package com.gwtt.ems.cmnb.southInterface.eventListener;


import com.gwtt.ems.cmnb.model.common.UpdateType;
import com.gwtt.ems.cmnb.model.south.EmsBaseData;

/**
 * Created by chenjj on 2019/8/22
 */
public class CmnbEvent {

    public static enum ObjType{
        Ncd,
        Ne,
        Port,
        TopoLink,

    }

    private UpdateType updateType;
    private ObjType objType;

    private EmsBaseData oldObj;
    private EmsBaseData newObj;

    public UpdateType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(UpdateType updateType) {
        this.updateType = updateType;
    }

    public ObjType getObjType() {
        return objType;
    }

    public void setObjType(ObjType objType) {
        this.objType = objType;
    }

    public EmsBaseData getOldObj() {
        return oldObj;
    }

    public void setOldObj(EmsBaseData oldObj) {
        this.oldObj = oldObj;
    }

    public EmsBaseData getNewObj() {
        return newObj;
    }

    public void setNewObj(EmsBaseData newObj) {
        this.newObj = newObj;
    }

}
