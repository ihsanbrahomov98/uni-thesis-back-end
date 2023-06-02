package com.arjuncodes.studentsystem.controller.SitterAuthenticationController;

import com.arjuncodes.studentsystem.model.ProductModel.Sitter;
import com.arjuncodes.studentsystem.model.UserModel.User;
import com.arjuncodes.studentsystem.service.SitterAuthenticationService.SitterAuthenticationService;
import com.arjuncodes.studentsystem.service.UserAuthenticationService.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/sitter")
public class SitterAuthenticationController {
    @Autowired
    private SitterAuthenticationService sitterAuthenticationService;


    @PostMapping("/register")
    public ResponseEntity<?> registerSitter(@RequestBody Sitter sitter) {
        return sitterAuthenticationService.registerSitter(sitter);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginSitter(@RequestBody Sitter sitter) {
        return sitterAuthenticationService.loginSitter(sitter);
    }
}
