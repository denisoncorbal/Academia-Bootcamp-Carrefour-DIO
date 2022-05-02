package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.User;
import me.dio.academia.digital.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserServiceImpl service;

    UserController(UserServiceImpl service){
        this.service = service;
    }

    @PostMapping
    public void postUser(@RequestBody User user){
        service.createUser(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(service.getUsers());
    }
}
