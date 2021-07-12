package org.viktord8888.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class UserLoginEndpointExceptionHandler {
    @ExceptionHandler(value = { UserLoginFailureException.class })
    protected ResponseEntity<Object> handleConflict() {
        String bodyOfResponse = "This user doesn't exist.";
        return new ResponseEntity<>(bodyOfResponse, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
