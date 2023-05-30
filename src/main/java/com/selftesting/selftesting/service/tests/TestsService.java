package com.selftesting.selftesting.service.tests;

import com.selftesting.selftesting.dto.QuestionDto;
import com.selftesting.selftesting.entity.Test;
import com.selftesting.selftesting.repo.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestsService {
    private final TestRepository testRepository;

    public List<Test> findByIdSubjectAndIdGrade(Integer idSubject, Integer idGrade) {
        return testRepository.findByIdSubjectAndIdGrade(idSubject, idGrade);
    }


    public Object findTestById(Integer idTest){
        var tmp = testRepository.findTestById(idTest);
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for(Map<String, Object> test : testRepository.findTestById(idTest)){
            questionDtoList.add(
                    QuestionDto.builder()
                            .type((Short) test.get("id_type_question"))
                            .comment((String) test.get("comment"))
                            .points((Short) test.get("points"))
                            .question((Integer) test.get("id_question"))
                            .answers(new ArrayList<>())
                            .ranswer((String) test.get("answer"))
                    .build());
        }
        System.out.println("fdsa");
        return null;
    }
}
