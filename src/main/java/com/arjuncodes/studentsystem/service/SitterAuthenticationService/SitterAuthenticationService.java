package com.arjuncodes.studentsystem.service.SitterAuthenticationService;

import com.arjuncodes.studentsystem.model.ProductModel.Sitter;
import org.springframework.http.ResponseEntity;

public interface SitterAuthenticationService {
    public ResponseEntity<?> registerSitter(Sitter sitter);
    public ResponseEntity<?> loginSitter(Sitter sitter);
}
