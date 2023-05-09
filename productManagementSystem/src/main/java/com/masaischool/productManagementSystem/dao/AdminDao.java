package com.masaischool.productManagementSystem.dao;

import com.masaischool.productManagementSystem.entity.Admin;
import com.masaischool.productManagementSystem.entity.Category;
import com.masaischool.productManagementSystem.entity.Product;

import java.util.List;
//import com.masaischool.productManagementSystem.entity.Category;

public interface AdminDao {

    Admin getAdmin(String username);
    boolean resetPassword(String username, String password) throws Exception;

    List<Category> getAllCategory();
    void addNewCategory(Category category);
    public List<Product> getAllProduct();
    public void updateProduct(Product product);
    Product getProductById(int productId);

    void updateCategory(Category category);

    Category getCategoryById(int catId);

    void deleteProduct(int productId);
}
