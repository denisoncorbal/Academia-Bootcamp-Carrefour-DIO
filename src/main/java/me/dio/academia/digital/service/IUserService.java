package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    public void createUser(User user);

    public boolean existsByUsername(String username);

    public List<User> getUsers();
}
