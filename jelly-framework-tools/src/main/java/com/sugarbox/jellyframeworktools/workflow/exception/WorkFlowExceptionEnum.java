package com.sugarbox.jellyframeworktools.workflow.exception;

import lombok.Data;

public enum WorkFlowExceptionEnum {

    //common exception;
    FAIL("9999", "fail"),
    PARAMETERS_ERROR("0001", "parameter is error"),
    PARAMETER_NOT_NULL("0002", "parameter is not be null"),
    //repository service exception
    RE_DEFINITION_CREATED_FAIL("1000", "cannot deploy the process definition"),
    RE_DEFINITION_EXISTS("1001", "the definition exists"),
    ;

    private String code;

    private String message;

    WorkFlowExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public  String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
