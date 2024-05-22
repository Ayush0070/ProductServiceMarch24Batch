package com.example.firstspringapi.services;

import com.example.firstspringapi.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();
}
