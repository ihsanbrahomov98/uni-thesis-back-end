package com.arjuncodes.studentsystem.service.SitterAuthenticationService;

import com.arjuncodes.studentsystem.model.SitterModel.Sitter;
import com.arjuncodes.studentsystem.repository.SitterRepository.SitterRepository;
import com.arjuncodes.studentsystem.response.SitterResponse.SitterResponse;
import com.arjuncodes.studentsystem.service.SitterService.SitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SitterAuthenticationServiceImpl implements  SitterAuthenticationService{
    @Autowired
    private SitterRepository sitterRepository;
    @Autowired
    private SitterService sitterService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<?> registerSitter(Sitter sitter) {
        System.out.println("here2");
        if(sitterRepository.findByEmail(sitter.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken!");
        }
        sitter.setPassword(bCryptPasswordEncoder.encode(sitter.getPassword()));
        sitter.setRole("SITTER");
        sitter.setEmail(sitter.getEmail());
        sitter.setTelephone(sitter.getTelephone());
        sitter.setCity(sitter.getCity());
        sitterService.saveSitter(sitter);
        SitterResponse sitterResponse = new SitterResponse(sitter.getEmail(), sitter.getEmail(),
                sitter.getTelephone(),sitter.getRole(),sitter.getId());
        return ResponseEntity.ok(sitterResponse);
    }

    public ResponseEntity<?> loginSitter(Sitter sitter) {
        Sitter existingSitter = sitterRepository.findByEmail(sitter.getEmail());
        if(existingSitter == null) {
            return ResponseEntity.badRequest().body("Invalid credentials!");
        }
        boolean passwordMatches = bCryptPasswordEncoder.matches(sitter.getPassword(), existingSitter.getPassword());
        if(!passwordMatches) {
            return ResponseEntity.badRequest().body("Invalid credentials!");
        }
        String role = existingSitter.getRole();
        System.out.println(existingSitter.getEmail());
        SitterResponse sitterResponse = new SitterResponse(existingSitter.getEmail(), existingSitter.getEmail(),existingSitter.getTelephone(),existingSitter.getRole(),existingSitter.getId());
        return ResponseEntity.ok(sitterResponse);
    }
}
