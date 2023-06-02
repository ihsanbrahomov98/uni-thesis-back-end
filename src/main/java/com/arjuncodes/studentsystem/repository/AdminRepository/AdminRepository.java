package com.arjuncodes.studentsystem.repository.AdminRepository;

import com.arjuncodes.studentsystem.model.AdminModel.Admin;
import com.arjuncodes.studentsystem.model.ProductModel.Sitter;
import com.arjuncodes.studentsystem.model.UserModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    public List<User> findByUserId(String userId);
    Admin findByEmail(String email);
}
