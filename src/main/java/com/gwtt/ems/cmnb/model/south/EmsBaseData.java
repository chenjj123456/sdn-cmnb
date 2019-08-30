package com.gwtt.ems.cmnb.model.south;

/**
 * Rest API 返回结果 { errorCode:"", errorDesc:"", data:{} }
 * Created by chenjj on 2019/8/9
 */
public class EmsBaseData {
    public EmsBaseData() {
    }

    public EmsBaseData(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;

    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    protected String errorCode;
    protected String errorDesc = "";
}
