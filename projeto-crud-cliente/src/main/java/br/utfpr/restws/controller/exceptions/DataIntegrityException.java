package br.utfpr.restws.controller.exceptions;

public class DataIntegrityException extends Exception {
    public DataIntegrityException(String message) {
        super(message);
    }

    public DataIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }
}
