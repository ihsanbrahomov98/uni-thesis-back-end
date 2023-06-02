package com.arjuncodes.studentsystem.service.UserService;


import com.arjuncodes.studentsystem.model.UserModel.User;
import com.arjuncodes.studentsystem.repository.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getAllUsers(String productId){
        List<User> users = new ArrayList<>();
        userRepository.findBySitterId(productId).forEach(users::add);
        return users;
    }
    @Override
    public User updateUser(User user) {
        User userDB = userRepository.findById(user.getId()).get();
        userDB.setName(user.getName());
        userDB.setEmail(user.getName());
        return  userRepository.save(userDB);
    }

//    public User register(User user) {
//        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
//        user.setPassword(hashedPassword);
//        return userRepository.save(user);
//    }
//
//    public User login(String username, String password) {
//        User user = userRepository.findByUsername(username);
//        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
//            return user;
//        }
//        return null;
//    }



}
