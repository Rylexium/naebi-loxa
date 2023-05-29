package com.selftesting.selftesting.controllers.login;

import com.selftesting.selftesting.service.auth.AuthService;
import com.selftesting.selftesting.request.RequestLoginAndPass;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login-form")
    public String someControllerMethod(@RequestBody RequestLoginAndPass requestLoginAndPass) {
        if(authService.auth(requestLoginAndPass.getFieldLogin(), requestLoginAndPass.getFieldPass()))
            return "Успешно!";
        else
            return "Неверный логин или пароль!";
    }
}
