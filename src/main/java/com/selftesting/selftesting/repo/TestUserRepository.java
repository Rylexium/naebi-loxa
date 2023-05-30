package com.selftesting.selftesting.repo;

import com.selftesting.selftesting.entity.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestUserRepository extends JpaRepository<TestUser, Short> {
}
