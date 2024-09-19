package com.app.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ResourceNotFoundException extends ResponseStatusException {
    public ResourceNotFoundException(String entityName, Long id){
        super(HttpStatus.NOT_FOUND, String.format("Not results found for %s with id: %s", entityName, id));
    }
}
