package com.example.prefiks_a.model.exceptions;

public class MissingArgumentException extends RuntimeException{
    public MissingArgumentException(){
        super("Missing arguments");
    }
}
