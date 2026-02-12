package com.erp.backend.service;

import com.erp.backend.model.User;
import com.erp.backend.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {

        if (userRepository.existsByUsername( user.getUsername( ) )){
            throw new RuntimeException( "Username already exists" );
        }
        if(userRepository.existsByEmail( user.getEmail())){
            throw new RuntimeException( "Email already exists" );
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save( user );
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
