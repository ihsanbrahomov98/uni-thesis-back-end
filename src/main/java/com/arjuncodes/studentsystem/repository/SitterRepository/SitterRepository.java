package com.arjuncodes.studentsystem.repository.SitterRepository;
import com.arjuncodes.studentsystem.model.ProductModel.Sitter;
import com.arjuncodes.studentsystem.model.UserModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SitterRepository extends JpaRepository<Sitter,Long> {
    Sitter findByEmail(String email);
}