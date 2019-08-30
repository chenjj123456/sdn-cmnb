package com.gwtt.ems.cmnb.northInterface.RestError;

import com.gwtt.ems.cmnb.northInterface.RestError.RestconfError.*;

/**
 * Created by chenjj on 2019/8/9
 */
public class DealRestConfError {
    //400 bad request
    public static RestConfErrorList badRequest(){
        RestConfErrorList errorList=new RestConfErrorList();
        RestconfError restconfError=new RestconfError(ErrorType.PROTOCOL,ErrorTag.INVALID_VALUE,RestConfErrorMessage.BAD_REQUEST);
        errorList.setError(restconfError);
        return errorList;
    }

    // no content,return EmsError
    public static RestConfErrorList noContent(String errorDesc){
        RestConfErrorList errorList=new RestConfErrorList();
        RestconfError restconfError=new RestconfError(ErrorType.APPLICATION,ErrorTag.OPERATION_FAILED,errorDesc);
        errorList.setError(restconfError);
        return errorList;
    }

    //500 server error
    public static RestConfErrorList serverError(){
        RestConfErrorList errorList=new RestConfErrorList();
        RestconfError restconfError=new RestconfError(ErrorType.APPLICATION,ErrorTag.OPERATION_FAILED,RestConfErrorMessage.SERVER_ERROR);
        errorList.setError(restconfError);
        return errorList;
    }
}
