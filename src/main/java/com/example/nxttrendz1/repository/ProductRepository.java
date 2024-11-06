package com.example.nxttrendz1.repository;

import java.util.ArrayList;

import com.example.nxttrendz1.model.Product;

public interface ProductRepository {
    public ArrayList<Product> getListOfProducts();

    public Product getProductByGivenId(int productId);

    public Product addProductByGivenNewProductDetails(Product newProduct);

    public Product modifyProductDetailsByGivenId(int productId, Product productDetails);

    public Product deleteProductBasedOnGivenId(int productId);
    
}
