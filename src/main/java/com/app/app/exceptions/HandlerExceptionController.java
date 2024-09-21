package com.app.app.exceptions;

import com.app.app.utils.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Errors> notFound(Exception e){
        Errors errors = new Errors();
        errors.setDate(new Date());
        errors.setMessage(e.getMessage());
        errors.setError("Data not found");
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(errors);
    }
}
