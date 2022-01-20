package com.example.prefiks_a.model.exceptions;

public class WrongManufacturerIdException extends RuntimeException{
    public WrongManufacturerIdException(Long id){
        super(String.format("Manufacturer with id %d doesnt exist", id));
    }
}
