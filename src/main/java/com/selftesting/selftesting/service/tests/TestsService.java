package com.selftesting.selftesting.service.tests;

import com.selftesting.selftesting.dto.AnswerDto;
import com.selftesting.selftesting.dto.QuestionDto;
import com.selftesting.selftesting.entity.Test;
import com.selftesting.selftesting.repo.AnswerOptionsRepository;
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
    private final AnswerOptionsRepository answerOptionsRepository;

    public List<Test> findByIdSubjectAndIdGrade(Integer idSubject, Integer idGrade) {
        return testRepository.findByIdSubjectAndIdGrade(idSubject, idGrade);
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
