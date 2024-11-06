package com.example.nxttrendz1.repository;

import java.util.*;

import com.example.nxttrendz1.model.Review;

public interface ReviewRepository {
    public ArrayList<Review> getListOfReviews();

    public Review addGivenReview(Review newReview);

    public Review getReviewBasedOnGivenIdReviewId(int reviewId);

    // public Review updateReviewBasedOnGivenReviewId(int reviewId , Review reviewData);
}