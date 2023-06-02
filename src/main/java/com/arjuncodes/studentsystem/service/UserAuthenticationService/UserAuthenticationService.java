package com.arjuncodes.studentsystem.service.UserAuthenticationService;

import com.arjuncodes.studentsystem.model.UserModel.User;
import org.springframework.http.ResponseEntity;


public interface UserAuthenticationService {
    public ResponseEntity<?> registerUser( User user);
    public ResponseEntity<?> loginUser( User user);
}
