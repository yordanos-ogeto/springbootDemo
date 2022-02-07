package com.example.crudwithsb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
    private static final Long serialVersionUID= 1l;
   public ResourceNotFound(String message){
        super(message);
    }
}
