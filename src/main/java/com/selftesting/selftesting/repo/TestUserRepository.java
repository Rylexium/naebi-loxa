package com.selftesting.selftesting.repo;

import com.selftesting.selftesting.entity.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TestUserRepository extends JpaRepository<TestUser, Short> {
    @Query(value = "select login, score from test_user where id_test=:id_test", nativeQuery = true)
    List<Map<String, String>> getLoginByIdTest(@Param("id_test") Short idTest);

    @Query(value = "select (select name from test where test.id_test=test_user.id_test) as text, score \n" +
            "\tfrom test_user where login=:login", nativeQuery = true)
    List<Map<String, String>> getTestsByLogin(@Param("login") String login);
}
