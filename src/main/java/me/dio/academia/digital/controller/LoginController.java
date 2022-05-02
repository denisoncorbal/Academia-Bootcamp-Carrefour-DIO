package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Role;
import me.dio.academia.digital.entity.User;
import me.dio.academia.digital.entity.form.Login;
import me.dio.academia.digital.entity.form.Session;
import me.dio.academia.digital.repository.UserRepository;
import me.dio.academia.digital.security.JWTCreator;
import me.dio.academia.digital.security.JWTObject;
import me.dio.academia.digital.security.SecurityConfig;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.stream.Collectors;

@RestController
public class LoginController {

    private PasswordEncoder encoder;

    private UserRepository repository;

    private SecurityConfig securityConfig;

    LoginController(PasswordEncoder encoder, UserRepository repository, SecurityConfig securityConfig){
        this.encoder = encoder;
        this.repository = repository;
        this.securityConfig = securityConfig;
    }

    @PostMapping("/login")
    public Session logar(@RequestBody Login login){
        User user = repository.findByUsername(login.getUsername());


        if(user != null){
            boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());
            if(!passwordOk){
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }

            Session session = new Session();
            session.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setSubject(String.valueOf(user.getId()));
            jwtObject.setIssuedAt(new Date((System.currentTimeMillis())));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + securityConfig.getEXPIRATION())));
            jwtObject.setRoles(user.getRoles().stream().map(Role::getRolename).collect(Collectors.toList()));
            session.setToken(JWTCreator.create(securityConfig.getPREFIX(), securityConfig.getKEY(), jwtObject));
            return session;
        }
        else{
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
