package com.example.prefiks_a.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String username){
        super(String.format("Username %d already exists", username));
    }
}
