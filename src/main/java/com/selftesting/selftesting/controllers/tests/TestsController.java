package com.selftesting.selftesting.controllers.tests;

import com.selftesting.selftesting.request.RequestPostResultTest;
import com.selftesting.selftesting.request.RequestSubjectAndGrade;
import com.selftesting.selftesting.service.tests.TestsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("api/tests/result")
    public void saveTestResult(@RequestBody RequestPostResultTest request) {
        testsService.saveTestResult(request.getLogin(), request.getIdTest(), request.getPoints());
    }

    @GetMapping("api/tests/result")
    public Object getTestResult(@RequestParam(value="login") String login) {
        return testsService.getTestsResult(login);
    }

}
