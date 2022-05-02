package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Role;
import me.dio.academia.digital.service.impl.RoleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private RoleServiceImpl service;

    public RoleController (RoleServiceImpl service){
        this.service = service;
    }

    @PostMapping
    public void postRole(@RequestBody Role role){
        service.createRole(role);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getUsers(){
        return ResponseEntity.ok(service.getRoles());
    }
}
