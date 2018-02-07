package com.gabrielspassos.poc.infra;

import com.gabrielspassos.poc.exception.IdNotExistException;
import com.gabrielspassos.poc.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = IdNotExistException.class)
    public ResponseEntity<Error> idNotFound() {
        Error error = new Error("This person don't exist");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}