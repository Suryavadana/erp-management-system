package com.erp.backend.service;

import com.erp.backend.dto.LoginRequest;
import com.erp.backend.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
