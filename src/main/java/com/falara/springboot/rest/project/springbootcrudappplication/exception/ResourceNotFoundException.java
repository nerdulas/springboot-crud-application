package com.falara.springboot.rest.project.springbootcrudappplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = 7968894965283818065L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
