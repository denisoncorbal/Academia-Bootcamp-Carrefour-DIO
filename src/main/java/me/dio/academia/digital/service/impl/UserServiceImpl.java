package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.User;
import me.dio.academia.digital.repository.UserRepository;
import me.dio.academia.digital.service.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private UserRepository repository;

    private PasswordEncoder encoder;

    UserServiceImpl(UserRepository repository, PasswordEncoder encoder){
        this.repository = repository;
        this.encoder = encoder;
    }

    public void createUser(User user){
        String pass = user.getPassword();
        user.setPassword(encoder.encode(pass));
        repository.save(user);
    }

    public boolean existsByUsername(String username){
        return repository.existsByUsername(username);
    }

    public List<User> getUsers(){
        return repository.findAll();
    }
}
