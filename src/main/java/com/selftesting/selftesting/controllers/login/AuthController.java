package com.selftesting.selftesting.controllers.login;

import com.selftesting.selftesting.request.RequestLoginAndPass;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthController {
    @PostMapping("/login-form")
    public String someControllerMethod(@RequestBody RequestLoginAndPass requestLoginAndPass) {
        System.out.println(requestLoginAndPass.getFieldLogin());
        System.out.println(requestLoginAndPass.getFieldPass());
        if(requestLoginAndPass.getFieldLogin().equals("admin") && requestLoginAndPass.getFieldPass().equals("admin")){
            return "success";
        }
        else {
            return "not success";
        }
    }
}
