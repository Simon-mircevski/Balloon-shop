package com.example.prefiks_a.service.impl;

import com.example.prefiks_a.model.User;
import com.example.prefiks_a.model.enumeration.Role;
import com.example.prefiks_a.model.exceptions.InvalidArgumentsException;
import com.example.prefiks_a.model.exceptions.PasswordsDoNotMatchException;
import com.example.prefiks_a.model.exceptions.UserNotFoundException;
import com.example.prefiks_a.model.exceptions.UsernameAlreadyExistsException;
import com.example.prefiks_a.repository.jpa.UserRepository;
import com.example.prefiks_a.service.AuthService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String name, String surname, String password, String repeatPassword, Role role) {
        if(username==null||username.isEmpty()||password.isEmpty()||password==null){
            throw new InvalidArgumentsException();
        }
        if(!password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }
        if(this.userRepository.findByUsername(username).isPresent() || !this.userRepository.findByUsername(username).isEmpty()){
            throw new UsernameAlreadyExistsException(username);
        }

        User user = new User(username,passwordEncoder.encode(password),name,surname,role);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUsername(s).orElseThrow(()-> new UserNotFoundException(s));
    }
}
