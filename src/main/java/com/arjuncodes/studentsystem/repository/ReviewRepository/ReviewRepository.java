package com.arjuncodes.studentsystem.repository.ReviewRepository;
import com.arjuncodes.studentsystem.model.AdminModel.Admin;
import com.arjuncodes.studentsystem.model.ReviewModel.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
