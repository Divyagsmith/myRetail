package com.casestudy.myRetail.util;

import java.util.Map;

/**
 * Created by z071476 on 9/24/17.
 */
public class ErrorJsonResponse {

    public Integer status;
    public String error;
    public String message;

    public ErrorJsonResponse(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.error = (String) errorAttributes.get("error");
        this.message = (String) errorAttributes.get("message");
    }

}
