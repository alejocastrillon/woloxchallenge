/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services.exception;

import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.BadRequestException;
import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.NotFoundException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Handler exception.
 *
 * @author alejandroutp
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * Http status constant for bad request.
     */
    public static final HttpStatus HTTP_STATUS_BAD_REQUEST = HttpStatus
            .BAD_REQUEST;
    /**
     * Http status constant for not found.
     */
    public static final HttpStatus HTTP_STATUS_NOT_FOUND = HttpStatus.NOT_FOUND;

    /**
     * Handler for bad request exception.
     *
     * @param e Bad request exception information
     * @param request Web request where happened the exception
     * @return Response entity with the exception
     */
    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<ExceptionResponse> handleBadRequestException(
            BadRequestException e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HTTP_STATUS_BAD_REQUEST);
    }

    /**
     * Handler for not found exception.
     *
     * @param e Not found exception information
     * @param request Web request where happened the exception
     * @return Response entity with the exception
     */
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleNotFoundException(
            NotFoundException e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HTTP_STATUS_NOT_FOUND);
    }

}
