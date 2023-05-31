package com.selftesting.selftesting.service.tests;

import com.selftesting.selftesting.dto.AnswerDto;
import com.selftesting.selftesting.dto.QuestionDto;
import com.selftesting.selftesting.dto.ResultTestDto;
import com.selftesting.selftesting.dto.TestDto;
import com.selftesting.selftesting.entity.Test;
import com.selftesting.selftesting.entity.TestUser;
import com.selftesting.selftesting.repo.AnswerOptionsRepository;
import com.selftesting.selftesting.repo.TestRepository;
import com.selftesting.selftesting.repo.TestUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestsService {
    private final TestRepository testRepository;
    private final AnswerOptionsRepository answerOptionsRepository;
    private final TestUserRepository testUserRepository;

    public List<Test> findByIdSubjectAndIdGrade(Integer idSubject, Integer idGrade) {
        return testRepository.findByIdSubjectAndIdGrade(idSubject, idGrade);
    }

    public void saveTestResult(String login, Short idTest, String points) {
        testUserRepository.save(new TestUser(login, idTest, points));
    }

    public void deleteTest(Short idTest) {
        testRepository.deleteTestByIdTest(idTest);
    }

    public List<Map<String, String>> getLoginByIdTest(Short idTest) {
        List<Map<String, String>> mapList = new ArrayList<>();
        for (Map<String, String> login : testUserRepository.getLoginByIdTest(idTest)){
            mapList.add(new HashMap<>() {
                {
                    put("login", login.get("login"));
                    put("score", login.get("score"));
                }
            });
        }
        return mapList;
    }

    public List<Map<String, String>> getTestsByLogin(String login) {
        List<Map<String, String>> mapList = new ArrayList<>();
        for (Map<String, String> name : testUserRepository.getTestsByLogin(login)){
            mapList.add(new HashMap<>() {
                {
                    put("name", name.get("text"));
                    put("score", name.get("score"));
                }
            });
        }
        return mapList;
    }

    public Object getAllTests() {
        List<TestDto> testDtoList = new ArrayList<>();
        for(Test test : testRepository.findAll()){
            testDtoList.add(TestDto.builder()
                            .id(test.getIdTest())
                            .name(test.getName())
                    .build());
        }
        return testDtoList;
    }

    public Object getTestsResult(String login) {
        List<ResultTestDto> resultTestDtoList = new ArrayList<>();
        for(Map<String, Object> test : testRepository.findResultTestByLogin(login)) {
            resultTestDtoList.add(ResultTestDto.builder()
                            .name((String) test.get("name"))
                            .score((String) test.get("score"))
                    .build());
        }
        return resultTestDtoList;
    }

    public Object findTestById(Integer idTest){
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for(Map<String, Object> test : testRepository.findTestById(idTest)){
            List<AnswerDto> answerDtoList = new ArrayList<>();
            short index = 1;
            for (Map<Integer, Object> answerOptions : answerOptionsRepository.findByIdQuestion((Integer) test.get("id_question"))) {
                answerDtoList.add(AnswerDto.builder()
                        .idAnswer(index)
                        .answer((String) answerOptions.get("answer"))
                        .build());
                index += 1;
            }
            questionDtoList.add(
                    QuestionDto.builder()
                            .type((Short) test.get("id_type_question"))
                            .comment((String) test.get("comment"))
                            .points((Short) test.get("points"))
                            .question((String) test.get("text"))
                            .answers(answerDtoList)
                            .ranswer((String) test.get("answer"))
                    .build());
        }
        return questionDtoList;
    }
}
