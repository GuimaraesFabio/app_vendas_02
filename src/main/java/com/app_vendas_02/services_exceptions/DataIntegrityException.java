package com.app_vendas_02.services_exceptions;

/**
 * ObjectNotFoundException
 */
public class DataIntegrityException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DataIntegrityException(String msg) {
        super(msg);
    }
}