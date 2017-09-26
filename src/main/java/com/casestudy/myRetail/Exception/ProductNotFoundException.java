package com.casestudy.myRetail.Exception;

/**
 * Created by z071476 on 9/24/17.
 */
public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


}
