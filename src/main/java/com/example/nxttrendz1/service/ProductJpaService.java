package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
// import org.springframework.web.server.ResponseStatusException;
import java.util.*;
// import java.util.List;

import com.example.nxttrendz1.repository.ProductRepository;
import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.model.Product;

@Service
public class ProductJpaService implements ProductRepository {
    @Autowired
    private ProductJpaRepository myProductJpaRepository;

    @Override
    public ArrayList<Product> getListOfProducts() {
        List<Product> productsList = myProductJpaRepository.findAll();
        ArrayList<Product> listOfProducts = new ArrayList<>(productsList);

        return listOfProducts;
    }

    @Override
    public Product getProductByGivenId(int productId) {
        Product retrievedProduct = null;
        Optional<Product> optionalProduct = myProductJpaRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            retrievedProduct = optionalProduct.get();
        }
        return retrievedProduct;
    }

    @Override
    public Product addProductByGivenNewProductDetails(Product newProductData) {
        Product newAddedProduct = myProductJpaRepository.save(newProductData);
        // Product newAddedProduct =
        // myProductJpaRepository.findById(addedProduct.getProductId()).get();
        return newAddedProduct;
    }

    @Override
    public Product modifyProductDetailsByGivenId(int prooductId, Product productDetails) {
        Product existingProduct = myProductJpaRepository.findById(prooductId).get();
        if (existingProduct == null) {
            return null;
        }
        if (productDetails.getProductName() != null) {
            existingProduct.setProductName(productDetails.getProductName());
        }
        Double gotPrice = productDetails.getPrice();
        if (gotPrice != null) {
            existingProduct.setPrice(productDetails.getPrice());
        }
        Product modifiedProduct = myProductJpaRepository.save(existingProduct);

        return modifiedProduct;

    }

    @Override
    public Product deleteProductBasedOnGivenId(int productId) {
        Product existingProduct = myProductJpaRepository.findById(productId).get();
        if (existingProduct == null) {
            return null;
        }
        myProductJpaRepository.deleteById(productId);
        return existingProduct;
    }

}