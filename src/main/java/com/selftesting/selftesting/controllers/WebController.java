package com.selftesting.selftesting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/auth")
    public String auth() {
        return "auth/auth.html";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration/regi.html";
    }

    @GetMapping("/ui/tests")
    public String tests() {
        return "/ui/tests/tests.html";
    }
}
