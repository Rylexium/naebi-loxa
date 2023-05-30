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

    @GetMapping("/tests")
    public String tests() {
        return "ui/tests/tests.html";
    }

    @GetMapping("/teso")
    public String teso() {
        return "ui/test_solution/teso.html";
    }

    @GetMapping("/uste")
    public String uste() {
        return "ui/user_test/uste.html";
    }

    @GetMapping("/adus")
    public String adus() {
        return "ui/admin_users/adus.html";
    }

    @GetMapping("/adte")
    public String adte() {
        return "ui/admin_tests/adte.html";
    }
}
