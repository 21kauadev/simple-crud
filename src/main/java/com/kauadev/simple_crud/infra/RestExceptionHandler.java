package com.kauadev.simple_crud.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kauadev.simple_crud.domain.product.exceptions.ProductMissingFieldsException;
import com.kauadev.simple_crud.domain.product.exceptions.ProductNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ProductNotFoundException.class })
    private ResponseEntity<RestErrorMessage> productNotFoundHandler(ProductNotFoundException exception) {
        RestErrorMessage threatedError = new RestErrorMessage(HttpStatus.NOT_FOUND.value(), exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatedError);
    }

    @ExceptionHandler({ ProductMissingFieldsException.class })
    private ResponseEntity<RestErrorMessage> productMissingFieldsHandler(ProductMissingFieldsException exception) {
        RestErrorMessage threatedError = new RestErrorMessage(HttpStatus.BAD_REQUEST.value(), exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatedError);
    }

}
