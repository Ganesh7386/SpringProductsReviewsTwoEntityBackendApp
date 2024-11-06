package com.example.nxttrendz1.repository;

import java.util.ArrayList;

import com.example.nxttrendz1.model.Product;

public interface ProductRepository {
    public ArrayList<Product> getListOfProducts();

    public Product getProductByGivenId(int productId);
}
