package com.masaischool.productManagementSystem.service;

import java.util.List;

import com.masaischool.productManagementSystem.entity.Product;

public interface ProductService {
	public List<Product> viewAllProducts();
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public List<Product> viewProduct(int id);
	public List<Product> viewProductByCategory(String cname);
	public void rempveProduct(int pid);
	
}
