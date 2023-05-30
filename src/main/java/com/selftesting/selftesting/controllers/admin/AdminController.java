package com.selftesting.selftesting.controllers.admin;

import com.selftesting.selftesting.entity.Users;
import com.selftesting.selftesting.request.RequestDeleteUserByLogin;
import com.selftesting.selftesting.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping(value = "/tests")
    public Object viewTests() {
        return new HashMap<String, String>() {
            {
                put("page", "admin/tests");
                put("status", "Hello World!");
            }
        };
    }

    @GetMapping(value = "/users")
    public List<Users> viewUsers() {
        return adminService.getAllUsers();
    }

    @DeleteMapping(value = "/users")
    public void deleteUser(@RequestBody RequestDeleteUserByLogin request) {
        adminService.deleteUserById(request.getLogin());
    }
}
