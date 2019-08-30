package com.gwtt.ems.cmnb.northInterface.RestError;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chenjj on 2019/8/8
 */
@XmlRootElement(name = "errors")
public class RestConfErrorList {

    private RestconfError error;

    public RestconfError getError() {
        return error;
    }

    public void setError(RestconfError error) {
        this.error = error;
    }
}
