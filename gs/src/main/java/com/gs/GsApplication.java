package com.gs;

import com.gs.domain.security.Role;
import com.gs.domain.security.UserRole;
import com.gs.service.UserService;
import com.gs.domain.User;
import com.gs.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class GsApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(GsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstName("Ayush");
        user1.setLastName("Dwivedi");
        user1.setUsername("frost");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
        user1.setEmail("ayush.d@beehyv.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        //role1.setRoleID(1);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1, userRoles);
    }
}
