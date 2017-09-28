package com.casestudy.myRetail.Exception;

/**
 * Created by z071476 on 9/27/17.
 */
public class ProductNotNumberException extends Exception {

    public ProductNotNumberException(String message) {
        super(message);
    }

    public ProductNotNumberException(String message, Throwable cause) {
        super(message, cause);
    }

}
