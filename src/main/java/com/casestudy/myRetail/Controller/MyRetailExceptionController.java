package com.casestudy.myRetail.Controller;

import com.casestudy.myRetail.Exception.ProductNotFoundException;
import com.casestudy.myRetail.Exception.ProductNotNumberException;
import com.casestudy.myRetail.util.ErrorJsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by z071476 on 9/27/17.
 */
@ControllerAdvice
public class MyRetailExceptionController {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    ErrorJsonResponse handleException(ProductNotFoundException exception) {
        return new ErrorJsonResponse(HttpStatus.NOT_FOUND, exception);

    }

    @ExceptionHandler(java.lang.NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorJsonResponse handleException(Exception exception) {
        return new ErrorJsonResponse(HttpStatus.BAD_REQUEST, new ProductNotNumberException
                ("Invalid Product Number.", exception));

    }
}
