package ru.srb.lcsweateroraclefreemarker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.srb.lcsweateroraclefreemarker.domain.Role;
import ru.srb.lcsweateroraclefreemarker.domain.User;
import ru.srb.lcsweateroraclefreemarker.repos.RoleRepo;
import ru.srb.lcsweateroraclefreemarker.repos.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role roleUser = roleRepository.findByName("ROLE_USER");
        if (roleUser == null) {
            roleUser = new Role();
            roleUser.setName("ROLE_USER");
            roleRepository.save(roleUser);
        }

        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        user.setRoles(userRoles);
        userRepo.save(user);
        return "redirect:/login";
    }
}
