package com.example.nxttrendz1.controller;

//  You can use the following import statements

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.service.ProductJpaService;

@RestController
public class ProductController {

    @Autowired
    private ProductJpaService myProductJpaService;

    @GetMapping("/greet")
    public String greet() {
        return "Hi The java developer";
    }

    @GetMapping("/products")
    public ArrayList<Product> getListOfProductsFromDb() {
        ArrayList<Product> listOfProductsFromDb = myProductJpaService.getListOfProducts();
        return listOfProductsFromDb;
    }

    @GetMapping("products/{productId}")
    public Product getProductBasedOnGivenIdFromDb(@PathVariable int productId) {
        Product existingProduct = myProductJpaService.getProductByGivenId(productId);
        if (existingProduct == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return existingProduct;
    }

    @PostMapping("/products")
    public Product addNewGivenproduct(@RequestBody Product newProductData) {
        Product newAddedProduct = myProductJpaService.addProductByGivenNewProductDetails(newProductData);
        return newAddedProduct;
    }

    @PutMapping("/products/{productId}")
    public Product modifyExistingProduct(@RequestBody Product productDetails, @PathVariable int productId) {
        Product modifiedProduct = myProductJpaService.modifyProductDetailsByGivenId(productId, productDetails);
        if (modifiedProduct == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return modifiedProduct;
    }

    @DeleteMapping("/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductBasedOnGivenId(@PathVariable int productId) {
        Product deletedProduct = myProductJpaService.deleteProductBasedOnGivenId(productId);
        if (deletedProduct == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        }
    }

}