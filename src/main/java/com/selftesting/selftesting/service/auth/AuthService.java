package com.selftesting.selftesting.service.auth;

import com.selftesting.selftesting.entity.Users;
import com.selftesting.selftesting.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsersRepository usersRepository;

    public boolean auth(String login, String password) {
        return usersRepository.findByLoginAndPassword(login, password) != null;
    }

    public boolean isUserExists(String login) {
        return usersRepository.findByLogin(login) != null;
    }

    public Optional<Users> findByLogin(String login) {
        return usersRepository.findById(login);
    }


    public void registration(String login, String password) {
        usersRepository.save(new Users(login, password));
    }
}
