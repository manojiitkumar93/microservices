package com.productService.exception;

public class ProductUnAvailabilityException extends  RuntimeException{

    public ProductUnAvailabilityException(String message){
        super(message);
    }
}
