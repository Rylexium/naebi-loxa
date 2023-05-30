package com.selftesting.selftesting.service.admin;

import com.selftesting.selftesting.entity.Users;
import com.selftesting.selftesting.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public void deleteUserById(String login) {
        usersRepository.deleteById(login);
    }
}
