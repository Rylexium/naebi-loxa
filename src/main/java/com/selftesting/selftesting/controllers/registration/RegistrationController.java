package com.selftesting.selftesting.controllers.registration;

import com.selftesting.selftesting.request.RequestLoginAndPass;
import com.selftesting.selftesting.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final AuthService authService;
    @PostMapping("/regi")
    public String registration(@RequestBody RequestLoginAndPass requestLoginAndPass) {
        System.out.println(requestLoginAndPass.getFieldLogin());
        System.out.println(requestLoginAndPass.getFieldPass());
        if(authService.is_user_exists(requestLoginAndPass.getFieldLogin())) {
            return "Пользователь с таким логином уже существует!";
        }

        authService.registration(requestLoginAndPass.getFieldLogin(), requestLoginAndPass.getFieldPass());
        return "Регистрация произошла успешна!";
    }
}
