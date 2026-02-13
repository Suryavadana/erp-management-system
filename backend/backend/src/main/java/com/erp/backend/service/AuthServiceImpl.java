package com.erp.backend.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.erp.backend.dto.LoginRequest;
import com.erp.backend.dto.LoginResponse;
import com.erp.backend.model.User;
import com.erp.backend.repository.UserRepository;
import com.erp.backend.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;
//    @Override
//    public Object login(LoginRequest request){
//        return Map.of(
//                "message","Login endpoint working",
//                "username" ,request.getUsername()
//        );
//    }

    @Override
    public LoginResponse login(LoginRequest request) {

        System.out.println("LOGIN REQUEST: " + request.getUsername());

        User user = userRepository.findByUsername( request.getUsername( ) )
                .orElseThrow( () -> new RuntimeException( "User not found" ) );

        System.out.println("USER FOUND: " + user.getUsername());

//        if (!passwordEncoder.matches( request.getPassword( ), user.getPassword( ) )) {
//            throw new RuntimeException( "Invalid username or password" );
//        }

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        //System.out.println("PASSWORD MATCH: " + matches);

        if (!matches) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken( user.getUsername( ) );
        //System.out.println( "Token generated" );
        return new LoginResponse( token );
    }
}
