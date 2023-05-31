package com.selftesting.selftesting.service.admin;

import com.selftesting.selftesting.entity.Users;
import com.selftesting.selftesting.service.auth.AuthService;
import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceTest {
    @Autowired
    private AuthService authService;
    @Autowired
    private AdminService adminService;

    private String Keccak256(String pass) {
        Keccak.Digest256 digestKeccak = new Keccak.Digest256();
        return Hex.toHexString(digestKeccak.digest(pass.getBytes()));
    }

    @Test
    void getAllUsers() throws Exception {
        Assert.isTrue(adminService.getAllUsers().size() != 0, "Не вернулись пользователи");

        int previousSize = adminService.getAllUsers().size();
        authService.registration("test_user1", Keccak256("some password"));
        Assert.isTrue(adminService.getAllUsers().size() == previousSize + 1,
                "Вернулись не всё пользователи, после добавление ещё одного");
    }

    @Test
    void deleteUserById() {
        int previousSize = adminService.getAllUsers().size();
        adminService.deleteUserById("test_user1");
        Assert.isTrue(adminService.getAllUsers().size() == previousSize - 1,
                "Не удалось удалить пользователя");

        previousSize = adminService.getAllUsers().size();
        adminService.deleteUserById("test_user13532");
        Assert.isTrue(adminService.getAllUsers().size() == previousSize,
                "Удалось удалить пользователя, которого не существует");
    }
}