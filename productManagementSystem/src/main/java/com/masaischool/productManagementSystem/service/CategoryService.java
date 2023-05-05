package com.masaischool.productManagementSystem.service;

import java.util.List;

import com.masaischool.productManagementSystem.entity.Product;

public interface CategoryService {
	public List<Product> viewAllProducts(String catName);
}
