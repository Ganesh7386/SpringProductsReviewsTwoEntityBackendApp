package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
// import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.nxttrendz1.repository.ReviewJpaRepository;
import com.example.nxttrendz1.repository.ReviewRepository;
import com.example.nxttrendz1.service.ProductJpaService;
import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.model.Product;

@Service
public class ReviewJpaService implements ReviewRepository {

    @Autowired
    private ReviewJpaRepository myReviewJpaRepository;

    @Autowired
    private ProductJpaService myProductJpaService;

    @Override
    public ArrayList<Review> getListOfReviews() {
        List<Review> reviewsList = myReviewJpaRepository.findAll();
        ArrayList<Review> listOfReviews = new ArrayList<>(reviewsList);
        return listOfReviews;
    }

    @Override
    public Review addGivenReview(Review newReview) {
        Product givenProduct = newReview.getProduct();
        int givenProductId = givenProduct.getProductId();
        Product existingProduct = myProductJpaService.getProductByGivenId(givenProductId);
        if (existingProduct == null) {
            return null;
        }
        newReview.setProduct(existingProduct);
        Review newAddedReview = myReviewJpaRepository.save(newReview);
        return newAddedReview;
    }

    @Override
    public Review getReviewBasedOnGivenIdReviewId(int reviewId) {
        Review existingReview = myReviewJpaRepository.findById(reviewId).get();
        if(existingReview == null) {
            return null;
        }
        return existingReview;

    }

    // @Override
    // public Review updateReviewBasedOnGivenReviewId(int reviewId , Review reviewData) {
    //     Review existingReview = myReviewJpaRepository.findById(reviewId).get();
    //     if(existingReview == null) {
    //         return null;
    //     }
    //     if(reviewData.getReviewContent() != null) {
    //         existingReview.setReviewContent(reviewData.getReviewContent());
    //     }
    //     if(reviewData.getRating() != null) {
    //         existingReview.setRating(reviewData.getRating());
    //     }
    //     if(reviewData.getProduct() != null) {
    //         Product gotProduct = reviewData.getProduct();
    //         int gotProductId = gotProduct.getProductId();
    //         if()
    //     }
    // }
}