package com.arjuncodes.studentsystem.service.ReviewService;

import com.arjuncodes.studentsystem.model.SitterModel.Sitter;
import com.arjuncodes.studentsystem.model.ReviewModel.Review;
import com.arjuncodes.studentsystem.repository.ReviewRepository.ReviewRepository;
import com.arjuncodes.studentsystem.repository.SitterRepository.SitterRepository;
import com.arjuncodes.studentsystem.service.SitterService.SitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements  ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    SitterService sitterService;
    @Autowired
    SitterRepository sitterRepository;
    public Sitter saveReview(Review review, Long sitterId) {
        Sitter reviewDB =  sitterService.fetchSitterById(sitterId);
        if (reviewDB != null) {
            review.setSitter(reviewDB);
            reviewDB.getReview().add(review);
            return sitterRepository.save(reviewDB);
        }
        return null;
    }
    public Sitter findAll(Long sitterId){
        Sitter reviewDB =  sitterService.fetchSitterById(sitterId);
        double sum = 0;
        if (reviewDB != null) {
            for (Review item : reviewDB.getReview()) {
                sum += Double.parseDouble(item.getRating());
            }
            reviewDB.setRating(String.valueOf(sum / reviewDB.getReview().size()));
            return sitterRepository.save(reviewDB);
        }
        return sitterService.fetchSitterById(sitterId);
    };
}
