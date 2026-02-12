package com.erp.backend.service;

import com.erp.backend.dto.CreateUserRequest;
import com.erp.backend.dto.UserResponse;
import com.erp.backend.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public interface UserService {
    UserResponse createUser (CreateUserRequest request);

    List<UserResponse> getAllUsers();


}
