package com.app.app.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class MakeValidation {
    public ResponseEntity<?>  validation(BindingResult fields){
        Map<String, String> errors = new HashMap<>();
        fields.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "The " + error.getField() + error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
