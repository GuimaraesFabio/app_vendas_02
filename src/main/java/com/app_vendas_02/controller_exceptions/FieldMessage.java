package com.app_vendas_02.controller_exceptions;

import java.io.Serializable;

/**
 * FieldMessage
 */
public class FieldMessage implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String fieldName;
    private String message;

    public FieldMessage() {
    }

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public FieldMessage fieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FieldMessage message(String message) {
        this.message = message;
        return this;
    }

}