package com.example.nxttrendz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;

import com.example.nxttrendz1.service.ReviewJpaService;
import com.example.nxttrendz1.model.Review;

@RestController
public class ReviewController {
    @Autowired
    private ReviewJpaService myReviewJpaService;

    @GetMapping("/products/reviews")
    public ArrayList<Review> retrieveListOfReviews() {
        ArrayList<Review> listOfReviews = myReviewJpaService.getListOfReviews();
        return listOfReviews;
    }

    @PostMapping("/products/reviews")
    public Review addGivenReviewToDb(@RequestBody Review newReviewData) {
        Review newAddedReview = myReviewJpaService.addGivenReview(newReviewData);
        if (newAddedReview == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return newAddedReview;
    }

    @GetMapping("/products/reviews/{reviewId}")
    public Review getReviewBasedOnGivenIdReviewId(@PathVariable int reviewId) {
        Review existingReview = myReviewJpaService.getReviewBasedOnGivenIdReviewId(reviewId);
        if(existingReview == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Review not found");
        }
        return existingReview;
    }
}