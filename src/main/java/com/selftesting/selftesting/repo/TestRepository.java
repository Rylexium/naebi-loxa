package com.selftesting.selftesting.repo;

import com.selftesting.selftesting.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TestRepository extends JpaRepository<Test, Integer> {
    @Query(value = "SELECT * " +
            " FROM public.test where id_subject=:id_subject and id_grade=:id_grade", nativeQuery = true)
    List<Test> findByIdSubjectAndIdGrade(@Param("id_subject") Integer idSubject, @Param("id_grade") Integer idGrade);

    @Query(value = "select id_question, \n" +
            "\t(select prompt from type_question where id_type=id_type_question) as comment,\n" +
            "\ttext, answer, points, id_type_question from question where id_test=:id_test", nativeQuery = true)
    List<Map<String, Object>> findTestById(@Param("id_test") Integer idTest);

}
