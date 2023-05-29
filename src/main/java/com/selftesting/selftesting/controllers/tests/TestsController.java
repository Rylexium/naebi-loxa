package com.selftesting.selftesting.controllers.tests;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestsController {
    @PostMapping("/tests")
    public String someMethod() {

        return "fasdfs";
    }

    @GetMapping("/atest")
    public String someMethodGet() {

        return "fasdfs";
    }

}
