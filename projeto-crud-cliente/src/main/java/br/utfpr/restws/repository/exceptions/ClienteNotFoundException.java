package br.utfpr.restws.repository.exceptions;

public class ClienteNotFoundException extends Exception {
    public ClienteNotFoundException(String message) {
        super(message);
    }

    public ClienteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
