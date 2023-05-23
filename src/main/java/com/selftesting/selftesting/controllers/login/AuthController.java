package com.selftesting.selftesting.controllers.login;

import com.selftesting.selftesting.request.RequestLoginAndPass;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AuthController {
    @PostMapping("/login-form")
    public String someControllerMethod(@RequestBody RequestLoginAndPass requestLoginAndPass) {
        System.out.println(requestLoginAndPass.getFieldLogin());
        System.out.println(requestLoginAndPass.getFieldPass());

        return "successful";
    }
}
