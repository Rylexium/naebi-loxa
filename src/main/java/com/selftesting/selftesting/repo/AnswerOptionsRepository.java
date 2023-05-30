package com.selftesting.selftesting.repo;

import com.selftesting.selftesting.entity.AnswerOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface AnswerOptionsRepository extends JpaRepository<AnswerOptions, Short> {
    @Query(value = "select answer from answer_options where id_question=:id_question order by id_answer asc;", nativeQuery = true)
    List<Map<Integer, Object>> findByIdQuestion(@Param("id_question") Integer idQuestion);
}
