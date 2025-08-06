package com.kauadev.simple_crud.domain.product.exceptions;

public class ProductMissingFieldsException extends RuntimeException {

    public ProductMissingFieldsException(String msg) {
        super(msg);
    }

    public ProductMissingFieldsException() {
        super("Missing fields.");
    }

}
