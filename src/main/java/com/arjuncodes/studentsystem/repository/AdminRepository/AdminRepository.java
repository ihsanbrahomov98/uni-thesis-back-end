package com.arjuncodes.studentsystem.repository.AdminRepository;

import com.arjuncodes.studentsystem.model.AdminModel.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmail(String email);
}
