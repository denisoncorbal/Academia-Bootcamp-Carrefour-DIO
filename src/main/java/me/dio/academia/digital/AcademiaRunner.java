package me.dio.academia.digital;

import me.dio.academia.digital.entity.Role;
import me.dio.academia.digital.entity.User;
import me.dio.academia.digital.repository.RoleRepository;
import me.dio.academia.digital.service.impl.UserServiceImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AcademiaRunner implements ApplicationRunner {

    private UserServiceImpl userService;
    private RoleRepository roleRepository;

    public AcademiaRunner(UserServiceImpl userService, RoleRepository roleRepository){
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{
        if (args != null) {
            Role adminRole = new Role();
            adminRole.setRolename("ADMIN");
            adminRole.setDescription("Admin role");

            if(!roleRepository.existsByRolename(adminRole.getRolename())) roleRepository.save(adminRole);

            User admin = new User();
            admin.setUsername(args.getOptionValues("username").get(0));
            admin.setPassword(args.getOptionValues("password").get(0));
            admin.setName("admin");
            admin.setRoles(List.of(adminRole));

            if(!userService.existsByUsername(admin.getUsername())) userService.createUser(admin);

        }
    }
}
