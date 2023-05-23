package com.selftesting.selftesting.controllers.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/auth")
    public String auth() {
        return "auth/auth.html";
    }
}
