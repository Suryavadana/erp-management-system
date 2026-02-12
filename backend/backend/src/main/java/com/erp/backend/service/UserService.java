package com.erp.backend.service;

import com.erp.backend.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public interface UserService {
    User createUser (User user);

    List<User> getAllUsers();


}
