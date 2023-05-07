package com.example.kometsales.exceptions;

public class FlowerException extends RuntimeException {

    public FlowerException(String message) {
        super(message);
    }

    public FlowerException(String message, Throwable cause) {
        super(message, cause);
    }
}
