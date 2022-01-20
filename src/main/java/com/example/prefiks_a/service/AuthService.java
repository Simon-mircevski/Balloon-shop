package com.example.prefiks_a.service;

import com.example.prefiks_a.model.User;
import com.example.prefiks_a.model.enumeration.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    User register(String username, String name, String surname, String password, String repeatPassword, Role role);
}
