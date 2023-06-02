package com.arjuncodes.studentsystem.repository.SearchRepository;

import com.arjuncodes.studentsystem.model.SearchModel.Search;
import com.arjuncodes.studentsystem.model.UserModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Search,Long> {

}
