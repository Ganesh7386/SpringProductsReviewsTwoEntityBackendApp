package com.example.nxttrendz1.model;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @Column(name = "REVIEWID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(name = "REVIEWCONTENT", nullable = false)
    private String reviewContent;

    @Column(name = "RATING")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "PRODUCTID", nullable = false)
    private Product productId;

    public Review() {
    }

    public Review(int reviewId, String reviewContent, int rating, Product productId) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.rating = rating;
        this.productId = productId;
    }

    public int getReviewId() {
        return this.reviewId;
    }

    public void setReviewId(int id) {
        this.reviewId = id;
    }

    public String getReviewContent() {
        return this.reviewContent;
    }

    public void setReviewContent(String newContent) {
        this.reviewContent = newContent;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Product getProductId() {
        return this.productId;
    }

    public void setProduct(Product productId) {
        this.productId = productId;
    }

}