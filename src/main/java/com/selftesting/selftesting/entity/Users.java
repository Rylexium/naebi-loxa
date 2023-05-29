package com.selftesting.selftesting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Users {
    @Id
    String login;
    String password;

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public Users() {
    }
}
