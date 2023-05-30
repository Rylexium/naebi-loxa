package com.selftesting.selftesting.controllers.tests;

import com.selftesting.selftesting.entity.Test;
import com.selftesting.selftesting.request.RequestSubjectAndGrade;
import com.selftesting.selftesting.service.tests.TestsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestsController {
    private final TestsService testsService;
    @PostMapping("/tests")
    public Object someMethod(@RequestBody RequestSubjectAndGrade request) {
        var list = testsService.findByIdSubjectAndIdGrade(request.getSubject(), request.getGrade());
        return list;
    }

}
