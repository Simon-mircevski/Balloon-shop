package com.example.prefiks_a.service.impl;

import com.example.prefiks_a.model.User;
import com.example.prefiks_a.model.exceptions.InvalidUserCredentialsException;
import com.example.prefiks_a.model.exceptions.MissingArgumentException;
import com.example.prefiks_a.repository.jpa.UserRepository;
import com.example.prefiks_a.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username==null||username.isEmpty()||password.isEmpty()||password==null){
            throw new MissingArgumentException();
        }
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatpassword, String name, String surname) {
        return null;
    }
}
