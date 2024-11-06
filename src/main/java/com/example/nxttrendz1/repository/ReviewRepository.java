package com.example.nxttrendz1.repository;

import java.util.*;

import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.model.Product;

public interface ReviewRepository {
    public ArrayList<Review> getListOfReviews();

    public Review addGivenReview(Review newReview);

    public Review getReviewBasedOnGivenIdReviewId(int reviewId);

    public Review updateReviewBasedOnGivenReviewId(int reviewId, Review reviewData);

    public Review deleteReviewBasedOnGivenReviewId(int reviewId);

    public Product getProductBasedOnGivenReviewId(int reviewId);
}