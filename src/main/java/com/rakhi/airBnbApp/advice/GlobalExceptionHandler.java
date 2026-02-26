package com.rakhi.airBnbApp.advice;

import com.rakhi.airBnbApp.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleHotelnoTfOUND(ResourceNotFoundException exception)
    {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        // global exception handling removes errors from logs
        //If you’re using @ControllerAdvice / @ExceptionHandler,
        // the exception is converted to a response and never logged unless you do it explicitly.

        log.error("ResourceNotFoundException occured",exception);
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleInternalServerError(Exception e)
    {
        ApiError apiError = ApiError.builder()
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        log.error("INTERNAL_SERVER_ERROR occured",e);
        return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleInputValidationError(MethodArgumentNotValidException exception)
    {
       List<String> errors = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError apiError = ApiError.builder()
                .message("Input validation failed")
               // .message(exception.getMessage())
                .subErrors(errors)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        log.error("MethodArgumentNotValidException occured", exception);
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }
}












