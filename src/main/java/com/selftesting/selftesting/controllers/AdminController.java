package com.selftesting.selftesting.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping(value = "/tests")
    public Object viewTests() {
        return new HashMap<String, String>() {
            {
                put("page", "admin/tests");
                put("status", "Hello World!");
            }
        };
    }

    @RequestMapping(value = "/users")
    public Object viewUsers() {
        return new HashMap<String, String>() {
            {
                put("page", "admin/users");
                put("status", "Hello World!");
            }
        };
    }
}
