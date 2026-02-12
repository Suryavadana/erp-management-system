package com.erp.backend.service;

import com.erp.backend.dto.CreateUserRequest;
import com.erp.backend.dto.UserResponse;
import com.erp.backend.exception.DuplicateResourceException;
import com.erp.backend.model.User;
import com.erp.backend.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(CreateUserRequest request) {

        if (userRepository.existsByUsername( request.getUsername( ) )){
            throw new DuplicateResourceException( "Username already exists" );
        }
        if(userRepository.existsByEmail( request.getEmail())){
            throw new DuplicateResourceException( "Email already exists" );
        }
        User user = new User();
        user.setUsername( request.getUsername());
        user.setEmail( request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())
        );
        user.setEnabled( true );
        User savedUser = userRepository.save( user );
        return mapToResponse(savedUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect( Collectors.toList());
    }

    private UserResponse mapToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setEnabled(user.getEnabled());
        response.setCreatedAt(user.getCreatedAt());
        return response;
    }
}
