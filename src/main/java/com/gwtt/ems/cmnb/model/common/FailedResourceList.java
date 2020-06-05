package com.gwtt.ems.cmnb.model.common;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenjj on 2019/9/17
 */
public class FailedResourceList {

    private String resourceId;

    private String errorCode;

    private String errorMessage;

    public String getResourceId() {
        return resourceId;
    }

    @XmlElement(name = "resource-id")
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @XmlElement(name = "error-code")
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @XmlElement(name = "error-message")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
