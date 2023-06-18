package com.arjuncodes.studentsystem.controller.ReviewController;

import com.arjuncodes.studentsystem.model.ProductModel.Sitter;
import com.arjuncodes.studentsystem.model.ReviewModel.Review;
import com.arjuncodes.studentsystem.model.SearchModel.Search;
import com.arjuncodes.studentsystem.service.ReviewService.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/review")
@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/all")
    public Sitter getAllReviews(@RequestBody Review review){
        Long id = review.getId();
        System.out.println(id);
        return reviewService.findAll(id);
   }

    @PostMapping("/add")
    public Sitter addReview(@RequestBody Review review){
        Long id = review.getId();
        return reviewService.saveReview(review,id);
    }
}
