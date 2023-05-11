package com.selftesting.selftesting.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class AuthenticationController {
    @RequestMapping("/login")
    public Object login() {
        return new HashMap<String, String>() {
            {
                put("page", "login");
                put("status", "Hello World!");
            }
        };
    }

    @RequestMapping("/registration")
    public Object registration() {
        return new HashMap<String, String>() {
            {
                put("page", "registration");
                put("status", "success");
            }
        };
    }
}
