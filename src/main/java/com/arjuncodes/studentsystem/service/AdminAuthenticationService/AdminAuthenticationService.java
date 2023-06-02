package com.arjuncodes.studentsystem.service.AdminAuthenticationService;

import com.arjuncodes.studentsystem.model.AdminModel.Admin;
import org.springframework.http.ResponseEntity;

public interface AdminAuthenticationService {
    public ResponseEntity<?> loginAdmin(Admin admin);
    public ResponseEntity<?> registerAdmin(Admin admin);
}
