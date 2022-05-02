package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Role;
import me.dio.academia.digital.repository.RoleRepository;
import me.dio.academia.digital.service.IRoleService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class RoleServiceImpl implements IRoleService {
    private RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository){
        this.repository = repository;
    }

    @Override
    public void createRole(Role role) {
        repository.save(role);
    }

    @Override
    public boolean existsByRolename(String rolename) {
        return repository.existsByRolename(rolename);
    }

    @Override
    public List<Role> getRoles(){
        return repository.findAll();

    }
}
