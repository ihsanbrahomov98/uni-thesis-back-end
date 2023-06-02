package com.arjuncodes.studentsystem.controller.AdminController;

import com.arjuncodes.studentsystem.model.AdminModel.Admin;
import com.arjuncodes.studentsystem.service.AdminService.AdminService;
import com.arjuncodes.studentsystem.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admins")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired()
    private UserService userService;

    @GetMapping("/all")
    public List<Admin> list(){
        return adminService.getAllAdmin();
    }

    @GetMapping("/findone/{id}")
    public Admin fetchAdminById(@PathVariable("id") Long  adminId){
        return adminService.fetchAdminById(adminId);
    }

    @PostMapping("/create")
    public Admin saveAdmin(@RequestBody Admin admin){
//        System.out.println(admin.getName());
//        User user =  userService.fetchUserById(Long.parseLong(admin.getAdminId()));
//        System.out.println(user);
//        admin.setUser(user);
//        TODO
        return  adminService.saveAdmin(admin);
    }

    @DeleteMapping("/delete")
    public String deleteAdminById(@RequestBody Admin admin){
        adminService.deleteAdminById(admin.getId());
        return "Admin deleted";
    }

    @CrossOrigin
    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin){
        return adminService.updateAdmin(admin);
    }
}
