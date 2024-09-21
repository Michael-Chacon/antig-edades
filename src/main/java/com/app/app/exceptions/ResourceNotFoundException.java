package com.app.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ResourceNotFoundException extends ResponseStatusException {
    public ResourceNotFoundException(String entityName, Long id){
        super(HttpStatus.NOT_FOUND, String.format("Not results found for table %s with id: %s", getNameClass(entityName), id));
    }

    /*
    * Creé este método porque olvidé utilizar getSimpleName() de la clase, y en su lugar usé getName(),
    * lo cual devuelve la ruta completa de la clase.
    * */
    public static String getNameClass(String path){
        int getLastPoint = path.lastIndexOf(".");
        return path.substring(getLastPoint + 1);
    }
}
