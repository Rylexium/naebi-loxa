package com.selftesting.selftesting.service.auth;

import com.selftesting.selftesting.entity.Users;
import com.selftesting.selftesting.service.admin.AdminService;
import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
class AuthServiceTest {
    @Autowired
    private AuthService authService;
    @Autowired
    private AdminService adminService;

    private String Keccak256(String pass) {
        Keccak.Digest256 digestKeccak = new Keccak.Digest256();
        return Hex.toHexString(digestKeccak.digest(pass.getBytes()));
    }

    @Test
    void authSuccess() {
        Assert.isTrue(
                authService.auth("test_user", Keccak256("qwerty123")),
                "Не удалось авторизоваться");

        Assert.isTrue(
                !authService.auth("test_user",Keccak256("qwerty1234")),
                "Удалось авторизоваться");
    }

    @Test
    void isUserExists() {
        Assert.isTrue(authService.isUserExists("test_user"), "Пользователь не существует");
        Assert.isTrue(!authService.isUserExists("qwerty"), "Пользователь существует");
    }

    @Test
    void findByLogin() {
        Assert.isTrue(
                Objects.equals(
                        authService.findByLogin("test_user").orElse(null),
                        new Users("test_user", Keccak256("qwerty123"))),
                "Не вернулся пользователь с корректными данными");

        Assert.isTrue(!Objects.equals(authService.findByLogin("test_user").orElse(null),
                        new Users("test_user", Keccak256("qwerty1234"))),
                "Вернулся пользователь с некорректными данными");
    }

    @Test
    void registration() {
        authService.registration("test_user123", Keccak256("1234567890"));
        Assert.isTrue(authService.isUserExists("test_user123"), "Пользователь не был зарегистрирован");

        authService.registration("test_user123", Keccak256("1234567893"));
        Assert.isTrue(authService.registration("test_user123", Keccak256("1234567893")).
                        equals("Пользователь с таким логином уже существует!"),
                "Удалось зарегистрировать существующего пользователя");
        adminService.deleteUserById("test_user123");
    }
}