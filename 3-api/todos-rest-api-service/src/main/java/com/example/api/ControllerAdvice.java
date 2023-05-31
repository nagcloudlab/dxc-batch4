package com.example.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(
            value = {NotFoundException.class}
    )
    public ResponseEntity<?> handleNotFoundException(Throwable e, HttpServletRequest request) {
        int status = 200;
        if (e instanceof NotFoundException) {
            status = 404;
        }
        HttpError httpError = new HttpError(request.getRequestURI(), status, e.getMessage());
        return ResponseEntity.status(status).body(httpError);
    }

}
