package com.app_vendas_02.controller_exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.app_vendas_02.services_exceptions.DataIntegrityException;
import com.app_vendas_02.services_exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ResourceExceptionHandler
 */

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        String error = "Objeto não encontrado.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> objectNotFound(DataIntegrityException e, HttpServletRequest request) {

        String error = "Erro de Integridade referencial.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidatorError> validatorErro(MethodArgumentNotValidException e, HttpServletRequest request) {

        String error = "Erro de validação";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidatorError err = new ValidatorError(Instant.now(), status.value(), error, error, request.getRequestURI());

        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            err.addErrors(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);
    }

}