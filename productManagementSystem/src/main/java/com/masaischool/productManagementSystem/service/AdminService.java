package com.masaischool.productManagementSystem.service;

import com.masaischool.productManagementSystem.entity.Category;
import com.masaischool.productManagementSystem.entity.Orders;
import com.masaischool.productManagementSystem.entity.Product;

public interface AdminService {
	public boolean updatePassword(String password,String username) throws Exception;
    boolean verifyCredential(String username, String password) throws Exception;
    void addProduct(Product product);


}
