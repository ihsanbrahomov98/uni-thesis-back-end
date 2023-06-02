package com.arjuncodes.studentsystem.service.AdminService;

import com.arjuncodes.studentsystem.model.AdminModel.Admin;
import com.arjuncodes.studentsystem.repository.AdminRepository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin fetchAdminById(Long adminId) {
        return adminRepository.findById(adminId).get();
    }

    @Override
    public void deleteAdminById(Long adminId) {
        adminRepository.deleteById(adminId);
    }


    @Override
    public Admin updateAdmin(Admin admin) {
        System.out.println(admin);
        Admin adminDB = adminRepository.findById(admin.getId()).get();
        adminDB.setUsername(admin.getUsername());
        adminDB.setEmail(admin.getEmail());

        return  adminRepository.save(adminDB);
    }
}
