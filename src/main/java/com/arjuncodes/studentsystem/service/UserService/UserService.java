package com.arjuncodes.studentsystem.service.UserService;

import com.arjuncodes.studentsystem.model.UserModel.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
        public User saveUser(User user);
    public List<User> getAllUser();

    public  User fetchUserById(Long userId);

    public void deleteUserById(Long userId);

    public User updateUser(User user);
    public List<User> getAllUsers(String productId);
//    public User register(User user);
//    public User login(String username, String password);
}
