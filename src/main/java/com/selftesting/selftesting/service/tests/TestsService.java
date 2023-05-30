package com.selftesting.selftesting.service.tests;

import com.selftesting.selftesting.entity.Test;
import com.selftesting.selftesting.repo.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestsService {
    private final TestRepository testRepository;

    public List<Test> findByIdSubjectAndIdGrade(Integer idSubject, Integer idGrade) {
        return testRepository.findByIdSubjectAndIdGrade(idSubject, idGrade);
    }
}
