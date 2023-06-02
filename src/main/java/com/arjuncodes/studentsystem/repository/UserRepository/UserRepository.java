package com.arjuncodes.studentsystem.repository.UserRepository;

import com.arjuncodes.studentsystem.model.UserModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public List<User> findBySitterId(String sitterId);
    User findByUsername(String username);
}
