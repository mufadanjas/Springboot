package com.batm.Day2.services;

import com.batm.Day2.entities.Category;
import com.batm.Day2.entities.Product;

import java.util.List;

public interface ProductService {
    // Untuk Create dan Update
    public boolean saveProduct(Product product);
    // Read Retrieve
    public List<Product> findAllProduct();
    public Product findProductById(int id);
    // Delete
    public boolean deleteProductById(int id);
}
