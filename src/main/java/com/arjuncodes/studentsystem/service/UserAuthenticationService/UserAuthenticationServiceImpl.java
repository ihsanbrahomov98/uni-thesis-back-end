package com.arjuncodes.studentsystem.service.UserAuthenticationService;

import com.arjuncodes.studentsystem.model.UserModel.User;
import com.arjuncodes.studentsystem.repository.UserRepository.UserRepository;
import com.arjuncodes.studentsystem.response.UserReponse.UserResponse;
import com.arjuncodes.studentsystem.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public ResponseEntity<?> registerUser(User user) {
        System.out.println(user.getPassword());
        if(userRepository.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken!");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        user.setEmail(user.getEmail());
        user.setTelephone(user.getTelephone());
        userService.saveUser(user);
        UserResponse userResponse = new UserResponse(user.getUsername(), user.getEmail(),
                user.getTelephone(),user.getRole(),user.getId());
        return ResponseEntity.ok(userResponse);
    }

    public ResponseEntity<?> loginUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser == null) {
            return ResponseEntity.badRequest().body("Invalid credentials!");
        }
        boolean passwordMatches = bCryptPasswordEncoder.matches(user.getPassword(), existingUser.getPassword());
        if(!passwordMatches) {
            return ResponseEntity.badRequest().body("Invalid credentials!");
        }
        String role = existingUser.getRole();
        System.out.println(existingUser.getEmail());
        UserResponse userResponse = new UserResponse(existingUser.getUsername(), existingUser.getEmail(),
                existingUser.getTelephone(),existingUser.getRole(),existingUser.getId());
        return ResponseEntity.ok(userResponse);
    }
}
