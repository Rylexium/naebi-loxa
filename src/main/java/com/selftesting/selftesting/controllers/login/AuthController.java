package com.selftesting.selftesting.controllers.login;

import com.selftesting.selftesting.config.JwtService;
import com.selftesting.selftesting.request.RequestLoginAndPass;
import com.selftesting.selftesting.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserDetailsService userDetailsService;
    private final AuthService authService;
    private final JwtService jwtService;

    @PostMapping("/login-form")
    public ResponseEntity<HashMap<String, Object>> authenticate(
            @RequestBody RequestLoginAndPass requestLoginAndPass) {

        if (authService.auth(requestLoginAndPass.getFieldLogin(), requestLoginAndPass.getFieldPass())) {
            final UserDetails user = userDetailsService.loadUserByUsername(
                    requestLoginAndPass.getFieldLogin());
            return ResponseEntity.ok(new HashMap<>() {
                {
                    put("status", "Успешно");
                    put("token", jwtService.generateToken(user));
                }
            });
        }

        return ResponseEntity.status(400).body(new HashMap<String, Object>() {
            {
                put("status", "Неправильный логин или пароль");
            }
        });
    }
}
