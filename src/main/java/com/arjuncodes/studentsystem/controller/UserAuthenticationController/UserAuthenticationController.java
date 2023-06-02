package com.arjuncodes.studentsystem.controller.UserAuthenticationController;

import com.arjuncodes.studentsystem.model.UserModel.User;
import com.arjuncodes.studentsystem.repository.UserRepository.UserRepository;
import com.arjuncodes.studentsystem.service.UserAuthenticationService.UserAuthenticationService;
import com.arjuncodes.studentsystem.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/user")
public class UserAuthenticationController {

    @Autowired
    private UserAuthenticationService userAuthenticationService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return userAuthenticationService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        return userAuthenticationService.loginUser(user);
    }
}