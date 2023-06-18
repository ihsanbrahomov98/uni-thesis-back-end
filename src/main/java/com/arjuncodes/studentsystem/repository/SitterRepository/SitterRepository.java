package com.arjuncodes.studentsystem.repository.SitterRepository;
import com.arjuncodes.studentsystem.model.SitterModel.Sitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SitterRepository extends JpaRepository<Sitter,Long> {
    Sitter findByEmail(String email);
}