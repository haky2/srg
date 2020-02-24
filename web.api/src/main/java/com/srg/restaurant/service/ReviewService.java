package com.srg.restaurant.service;

import com.srg.restaurant.entity.Review;
import com.srg.restaurant.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    protected ReviewRepository reviewRepo;

    /**
     * 전체 리뷰 조회 메소드
     * @return List<Review>
     */
    public List<Review> findAllReview() {
        return reviewRepo.findAll();
    }

    /**
     * 리뷰 번호로 리뷰 조회 메소드
     * @param reviewNo 리뷰 번호
     * @return Optional<Review>
     */
    public Optional<Review> findReviewByReviewNo(Integer reviewNo) {
        return reviewRepo.findById(reviewNo);
    }

    /**
     * 리뷰 저장 메소드
     * @param review 저장할 리뷰 객체
     * @return Review
     */
    public String saveReview(Review review) {
        Review newReview = reviewRepo.save(review);
        return String.format("/reviews/%d", newReview.getReviewNo());
    }

    public String modifyReview(Integer reviewNo, Review newReview) {
        Optional<Review> review = reviewRepo.findById(reviewNo);
        review.ifPresent( currentReview -> {
            currentReview.setScore(newReview.getScore());
            currentReview.setTitle(newReview.getTitle());
            currentReview.setContent(newReview.getContent());
            currentReview.setAttachment(newReview.getAttachment());
            reviewRepo.save(currentReview);
        });
        return String.format("/reviews/%d", reviewNo);
    }

    public void deleteReview(Integer reviewNo) throws Exception {
        Optional<Review> review = reviewRepo.findById(reviewNo);
        if (review.isPresent()) {
            reviewRepo.deleteById(reviewNo);
        } else {
            throw new Exception("Review does not exists.");
        }

    }
}
