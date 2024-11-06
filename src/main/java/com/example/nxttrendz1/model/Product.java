package com.example.nxttrendz1.model;
// You can use the following import statements

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "PRODUCTID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "PRODUCTNAME", nullable = false)
    private String productName;

    @Column(name = "PRICE")
    private int price;

    public Product() {
    }

    public Product(int id, String name, int price) {
        this.productId = id;
        this.productName = name;
        this.price = price;
    }

    // getters and setters
    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int id) {
        this.productId = id;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}