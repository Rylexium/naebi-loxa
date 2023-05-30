package com.selftesting.selftesting.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idResult;
    String login;
    Short idTest;
    String score;

    public TestUser(String login, Short idTest, String score) {
        this.idTest = idTest;
        this.login = login;
        this.score = score;
    }

    public TestUser(){
    }

    @PrePersist
    @PreUpdate
    private void onCreateOrUpdate() {
    }
}
