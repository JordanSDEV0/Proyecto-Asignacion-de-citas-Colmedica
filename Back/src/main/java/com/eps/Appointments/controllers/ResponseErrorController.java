package com.eps.Appointments.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseErrorController extends ResponseEntityExceptionHandler {

   @ExceptionHandler(value = { IllegalArgumentException.class })
   protected ResponseEntity<?> badRequest(RuntimeException runtimeException, WebRequest request) {
      return handleExceptionInternal(runtimeException, runtimeException.getMessage(), new HttpHeaders(),
            HttpStatus.BAD_REQUEST, request);
   }

}
