package com.sugarbox.jellyframeworktools.workflow.exception;

import java.io.Serializable;

public class WorkFlowException extends RuntimeException implements Serializable{

    protected final String code;


    public WorkFlowException() {
        super(WorkFlowExceptionEnum.FAIL.getMessage());
        code = WorkFlowExceptionEnum.FAIL.getCode();

    }

    public WorkFlowException(String code, String message) {
        super(message);
        this.code = code;
    }

    public WorkFlowException(WorkFlowExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

}
