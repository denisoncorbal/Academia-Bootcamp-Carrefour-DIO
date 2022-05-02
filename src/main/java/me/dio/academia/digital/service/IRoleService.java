package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Role;
import me.dio.academia.digital.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRoleService {

    public void createRole(Role role);

    public boolean existsByRolename(String rolename);

    public List<Role> getRoles();

}
