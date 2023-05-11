package com.selftesting.selftesting.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/tests")
    public Object chooseTest() {
        return new HashMap<String, String>() {
            {
                put("page", "user/tests");
                put("status", "Hello World!");
            }
        };
    }
}
