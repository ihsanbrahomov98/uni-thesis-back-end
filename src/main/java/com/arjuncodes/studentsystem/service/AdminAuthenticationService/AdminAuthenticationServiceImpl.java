package com.arjuncodes.studentsystem.service.AdminAuthenticationService;

import com.arjuncodes.studentsystem.model.AdminModel.Admin;
import com.arjuncodes.studentsystem.repository.AdminRepository.AdminRepository;
import com.arjuncodes.studentsystem.response.AdminResponse.AdminResponse;
import com.arjuncodes.studentsystem.service.AdminService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthenticationServiceImpl implements AdminAuthenticationService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<?> loginAdmin(Admin admin) {
        Admin existingAdmin = adminRepository.findByEmail(admin.getEmail());
        if (existingAdmin == null) {
            return ResponseEntity.badRequest().body("Invalid credentials!");
        }
        boolean passwordMatches = bCryptPasswordEncoder.matches(admin.getPassword(), existingAdmin.getPassword());
        if (!passwordMatches) {
            return ResponseEntity.badRequest().body("Invalid credentials!");
        }
        String role = existingAdmin.getRole();
        System.out.println(existingAdmin.getEmail());
        AdminResponse adminResponse = new AdminResponse(existingAdmin.getEmail(), existingAdmin.getEmail()
                , existingAdmin.getTelephone(), existingAdmin.getRole(), existingAdmin.getId());
        return ResponseEntity.ok(adminResponse);
    }
    public ResponseEntity<?> registerAdmin(Admin admin) {
//        System.out.println("here2");
//        if(adminRepository.findByEmail(admin.getEmail()) != null) {
//            return ResponseEntity.badRequest().body("Username is already taken!");
//        }
//        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
//        admin.setRole("ADMIN");
//        admin.setEmail(admin.getEmail());
//        admin.setTelephone(admin.getTelephone());
//        adminService.saveAdmin(admin);
//        AdminResponse adminResponse = new AdminResponse(admin.getEmail(), admin.getEmail()
//                , admin.getTelephone(), admin.getRole(), admin.getId());
//        return ResponseEntity.ok(adminResponse);
        return ResponseEntity.badRequest().body("You cant register admins!");
    }
}