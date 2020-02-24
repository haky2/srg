package com.srg.restaurant.controller;

import com.srg.restaurant.entity.Review;
import com.srg.restaurant.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/reviews")
public class ReviewRestController {
    @Autowired
    private ReviewService reviewService;
    private Map<String, Object> responseBody = new HashMap();

    @GetMapping
    public ResponseEntity<?> findAllReviews() {
        return ok(reviewService.findAllReview());
    }

    @PostMapping
    public ResponseEntity<?> registerReview(@RequestBody Review request) {
        return created(URI.create(reviewService.saveReview(request))).build();
    }

    @GetMapping(value = "/{reviewNo}")
    public ResponseEntity<?> findReviewByReviewNo(@PathVariable Integer reviewNo) {
        ResponseEntity response;
        Optional<Review> review = reviewService.findReviewByReviewNo(reviewNo);
        if (review.isPresent()) {
            response = ok(review);
        } else {
            response = notFound().build();
        }
        return response;
    }

    @PutMapping(value = "/{reviewNo}")
    public ResponseEntity<?> modifyReview(@PathVariable Integer reviewNo, @RequestBody Review request) {
        if (reviewNo == request.getReviewNo()) {
            try {
                String uri = reviewService.modifyReview(reviewNo, request);
                responseBody.put("path", URI.create(uri));
                return ok(responseBody);
            } catch (Exception e) {
                responseBody.put("message", e.getMessage());
                return badRequest().body(responseBody);
            }
        } else {
            responseBody.put("message", "reviewNo comparison failed.");
            return badRequest().body(responseBody);
        }
    }

    @DeleteMapping(value = "/{reviewNo}")
    public ResponseEntity<?> deleteReview(@PathVariable Integer reviewNo) {
        try {
            reviewService.deleteReview(reviewNo);
            return noContent().build();
        } catch (Exception e) {
            responseBody.put("message", e.getMessage());
            return badRequest().body(responseBody);
        }
    }
}
