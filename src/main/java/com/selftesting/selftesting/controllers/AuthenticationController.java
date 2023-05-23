package com.selftesting.selftesting.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RequiredArgsConstructor
//@RestController
//@ResponseBody
@Controller
public class AuthenticationController {
    @GetMapping("/auth")
    public String login(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        return "auth/auth.html";
    }
//
//    @RequestMapping("/registration")
//    public Object registration() {
//        return new HashMap<String, String>() {
//            {
//                put("page", "registration");
//                put("status", "success");
//            }
//        };
//    }
}
