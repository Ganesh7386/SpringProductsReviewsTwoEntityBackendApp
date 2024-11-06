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
    private Product product;

    public Review() {
    }

    public Review(int reviewId, String reviewContent, int rating, Product product) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.rating = rating;
        this.product = product;
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

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}