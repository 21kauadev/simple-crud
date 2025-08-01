package com.kauadev.simple_crud.domain.product.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String msg) {
        super(msg);
    }

    public ProductNotFoundException() {
        super("Produto não encontrado.");
    }

}
