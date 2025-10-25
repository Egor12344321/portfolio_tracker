package com.example.portfolio_tracker.service;

import com.example.portfolio_tracker.dto.RegistartionRequest;
import com.example.portfolio_tracker.models.User;
import com.example.portfolio_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(RegistartionRequest registrationRequest){
        if (userRepository.existsByUsername(registrationRequest.getUsername())){
            throw new RuntimeException("Юзер с таким именем уже есть");
        }
        if (userRepository.existsByEmail(registrationRequest.getEmail())){
            throw new RuntimeException("Пользователь с таким емэйлом уже есть");
        }

        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setUsername(registrationRequest.getUsername());

        return userRepository.save(user);
    }
}
