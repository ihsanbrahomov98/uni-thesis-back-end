package com.arjuncodes.studentsystem.service.ReviewService;

import com.arjuncodes.studentsystem.model.ProductModel.Sitter;
import com.arjuncodes.studentsystem.model.ReviewModel.Review;

public interface ReviewService {
    public Sitter saveReview(Review review, Long sitterId);
    public Sitter findAll(Long sitterId);
}
