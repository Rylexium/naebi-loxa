package com.selftesting.selftesting.repo;

import com.selftesting.selftesting.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, String> {
    Users findByLogin(String login);

    @Query(value = "SELECT login, password " +
            " FROM public.users where login=:login and password=:password", nativeQuery = true)
    Users findByLoginAndPassword(@Param("login") String login, @Param("password") String password);
}
