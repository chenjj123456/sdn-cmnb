package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by chenjj on 2019/9/17
 */
public class CommandResult {

    /**
     * 1 : success, 2 : failed, 3 : partly failed
     */
    private Byte result;

    List<SuccessResourceList> successResourceList;

    List<FailedResourceList> failedResourceList;

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    public List<SuccessResourceList> getSuccessResourceList() {
        return successResourceList;
    }

    @XmlElementWrapper(name = "success-resources")
    @XmlElement(name = "success-resource-list")
    public void setSuccessResourceList(List<SuccessResourceList> successResourceList) {
        this.successResourceList = successResourceList;
    }

    public List<FailedResourceList> getFailedResourceList() {
        return failedResourceList;
    }

    @XmlElementWrapper(name = "failed-resources")
    @XmlElement(name = "failed-resource-list")
    public void setFailedResourceList(List<FailedResourceList> failedResourceList) {
        this.failedResourceList = failedResourceList;
    }
}
