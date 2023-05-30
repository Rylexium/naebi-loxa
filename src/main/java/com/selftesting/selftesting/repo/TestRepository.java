package com.selftesting.selftesting.repo;

import com.selftesting.selftesting.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Integer> {
    @Query(value = "SELECT * " +
            " FROM public.test where id_subject=:id_subject and id_grade=:id_grade", nativeQuery = true)
    List<Test> findByIdSubjectAndIdGrade(@Param("id_subject") Integer idSubject, @Param("id_grade") Integer idGrade);
}
