package com.erp.backend.controller;

import com.erp.backend.dto.CreateUserRequest;
import com.erp.backend.dto.UserResponse;
import com.erp.backend.model.User;
import com.erp.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@Valid @RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }
}
