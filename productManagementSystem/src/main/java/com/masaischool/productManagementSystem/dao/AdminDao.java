package com.masaischool.productManagementSystem.dao;

import com.masaischool.productManagementSystem.entity.Admin;
import com.masaischool.productManagementSystem.entity.Category;

public interface AdminDao {

    Admin getAdmin(String username);
    String changePassword(String newPassword,String username) throws Exception;
    void addProduct(double price,String color, String specification, String manufacturer, int quantity, Category category);
}
