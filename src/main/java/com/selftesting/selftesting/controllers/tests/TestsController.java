package com.selftesting.selftesting.controllers.tests;

import com.selftesting.selftesting.entity.Test;
import com.selftesting.selftesting.request.RequestSubjectAndGrade;
import com.selftesting.selftesting.service.tests.TestsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestsController {
    private final TestsService testsService;
    @PostMapping("api/tests")
    public Object someMethod(@RequestBody RequestSubjectAndGrade request) {
        return testsService.findByIdSubjectAndIdGrade(request.getSubject(), request.getGrade());
    }

    @GetMapping("api/tests")
    public Object getTest(@RequestParam(value="idTest") Integer idTest) {
        return testsService.findTestById(idTest);
    }


}
