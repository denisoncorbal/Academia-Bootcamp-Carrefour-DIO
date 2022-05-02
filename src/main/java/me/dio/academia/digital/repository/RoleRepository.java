package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    boolean existsByRolename(String rolename);

}
