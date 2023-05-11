package com.selftesting.selftesting.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class ChooseTestController {
    @RequestMapping(value = "/choose_test")
    public Object chooseTest() {
        return new HashMap<String, String>() {
            {
                put("page", "chooseTest");
                put("status", "Hello World!");
            }
        };
    }

    @RequestMapping(value = "/testing")
    public Object viewTest() {
        return new HashMap<String, String>() {
            {
                put("page", "viewTest");
                put("status", "Hello World!");
            }
        };
    }
}
