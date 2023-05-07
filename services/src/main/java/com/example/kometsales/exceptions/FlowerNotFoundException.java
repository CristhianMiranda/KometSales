package com.example.kometsales.exceptions;

public class FlowerNotFoundException extends RuntimeException {

    public FlowerNotFoundException(Long id) {
        super("Flower not found with id " + id);
    }

}
