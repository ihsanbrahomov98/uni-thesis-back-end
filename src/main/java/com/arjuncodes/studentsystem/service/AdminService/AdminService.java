package com.arjuncodes.studentsystem.service.AdminService;

import com.arjuncodes.studentsystem.model.AdminModel.Admin;

import java.util.List;

public interface AdminService {
    public Admin saveAdmin(Admin admin);
    public List<Admin> getAllAdmin();

    public  Admin fetchAdminById(Long adminId);

    public void deleteAdminById(Long adminId);

  public   Admin updateAdmin(Admin admin);
}
