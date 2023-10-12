package com.example.loginjwt;

import com.example.loginjwt.entity.Role;
import com.example.loginjwt.entity.User;
import com.example.loginjwt.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
public class LoginjwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginjwtApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(IUserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Danh Vinh", "danhvinh", "1234", "danhvinhh@gmail.com",new HashSet<>()));
            userService.saveUser(new User(null, "Danh Khoa", "danhkhoa", "123456", "danhkhoa@gmail.com",new HashSet<>()));

            userService.addRoleToUser("danhvinhh@gmail.com", "ROLE_USER");
            userService.addRoleToUser("danhkhoa@gmail.com", "ROLE_ADMIN");
            userService.addRoleToUser("danhvinhh@gmail.com", "ROLE_MANAGER");
            userService.addRoleToUser("danhkhoa@gmail.com", "ROLE_SUPER_ADMIN");
        };
    }
}
