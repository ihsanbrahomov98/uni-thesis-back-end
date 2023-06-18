package com.arjuncodes.studentsystem.controller.UserController;


import com.arjuncodes.studentsystem.model.UserModel.User;
import com.arjuncodes.studentsystem.repository.UserRepository.UserRepository;
import com.arjuncodes.studentsystem.service.SitterService.SitterService;
import com.arjuncodes.studentsystem.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired()
    private UserService userService;
    @Autowired()
    private SitterService sitterService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){

        return userService.saveUser(user);
    }

    @GetMapping("/findone/{id}")
    public User getUserById(@PathVariable("id") Long  userId){
        return userService.fetchUserById(userId);
    }

    @DeleteMapping("/delete")
    public String deleteUserById(@RequestBody User user){
        userService.deleteUserById(user.getId());
        return "User deleted";
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

}
