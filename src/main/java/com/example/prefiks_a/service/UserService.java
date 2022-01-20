package com.example.prefiks_a.service;

import com.example.prefiks_a.model.User;

public interface UserService {
    User login(String username, String password);
    User register(String username, String password, String repeatpassword, String name, String surname);
}
