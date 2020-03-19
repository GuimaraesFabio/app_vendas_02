package com.app_vendas_02.controller_exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * ValidatorError
 */
public class ValidatorError extends StandardError {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidatorError() {
    }

    public ValidatorError(Instant timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return this.errors;
    }

    public void addErrors(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }

    public ValidatorError errors(List<FieldMessage> errors) {
        this.errors = errors;
        return this;
    }

}