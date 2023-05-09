package com.masaischool.productManagementSystem.service;

import com.masaischool.productManagementSystem.entity.Category;
import com.masaischool.productManagementSystem.entity.Product;

import java.util.List;

public interface AdminService {

    boolean verifyCredential(String username, String password) throws Exception;

    void resetPassword(String username,String password);
    List<Category> getAllCategory();
    void addNewCategory(Category category);

    List<Product> getAllProduct();

    void updateProduct(Product product);

    Product getProductById(int productId);

    void updateCategory(Category category);

    Category getCategoryById(int catId);

    void deleteProduct(int productId) throws Exception;
}
