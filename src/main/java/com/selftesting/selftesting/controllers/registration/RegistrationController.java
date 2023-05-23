package com.selftesting.selftesting.controllers.registration;

import com.selftesting.selftesting.request.RequestLoginAndPass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @PostMapping("/regi")
    public String registration(@RequestBody RequestLoginAndPass requestLoginAndPass) {
        System.out.println(requestLoginAndPass.getFieldLogin());
        System.out.println(requestLoginAndPass.getFieldPass());
        return "success";
    }
}
