package com.masaischool.productManagementSystem.service;

import java.util.List;

import com.masaischool.productManagementSystem.entity.Cart;
import com.masaischool.productManagementSystem.entity.Product;

public interface CartService {
	public void addProductToCart(Cart cart, Product p, int quantity);
	public void removeProductFromCart(Cart cart,Product p);
	public void updateProductQuantity(Cart cart,Product p, int quantity);
	public void removeAllProducts(Cart cart);
	public List<Cart> viewAllProducts(Cart cart);
}
