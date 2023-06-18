package com.arjuncodes.studentsystem.controller.AdminAuthenticationController;

import com.arjuncodes.studentsystem.model.AdminModel.Admin;
import com.arjuncodes.studentsystem.model.UserModel.User;
import com.arjuncodes.studentsystem.service.AdminAuthenticationService.AdminAuthenticationService;
import com.arjuncodes.studentsystem.service.UserAuthenticationService.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/admin")
public class AdminAuthenticationController {
    @Autowired
    private AdminAuthenticationService adminAuthenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin admin) {
        return
                adminAuthenticationService.loginAdmin(admin);
    }

//    @PostMapping("/register")
//    public ResponseEntity<?> registerAdmin(@RequestBody Admin admin) {
//        return adminAuthenticationService.registerAdmin(admin);
//    }
}
