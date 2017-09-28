package com.casestudy.myRetail.util;

import org.springframework.http.HttpStatus;

/**
 * Created by z071476 on 9/24/17.
 */
public class ErrorJsonResponse {

    public Integer status_code;
    public String error;
    public String message;


    public ErrorJsonResponse(HttpStatus status_code, Exception e) {

        this.status_code = status_code.value();
        this.error = e.getCause().getMessage();
        this.message = e.getMessage();

    }

}
