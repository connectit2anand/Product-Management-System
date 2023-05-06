package com.masaischool.productManagementSystem.ui;

import com.masaischool.productManagementSystem.entity.Cart;
import com.masaischool.productManagementSystem.entity.Category;
import com.masaischool.productManagementSystem.entity.Orders;
import com.masaischool.productManagementSystem.entity.Product;
import com.masaischool.productManagementSystem.service.AdminService;
import com.masaischool.productManagementSystem.serviceImpl.AdminServiceImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AdminUI {

    public void adminMain(Scanner sc) {
        System.out.println("Enter the username");
        String username = sc.next();
        System.out.println("Enter the password");
        String password = sc.next();
        AdminService adminService = new AdminServiceImpl();
        try {
            adminService.verifyCredential(username, password);
            System.out.println("Logged in successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        Orders order = new Orders();
        Cart cart = new Cart();
        Product p1 = new Product();
        Set<Product> products = new HashSet<>();
        products.add(p1);
        Category category = new Category("Jeans", products);
//        Product p1 = new Product("Jeans", 2000.00, "Black",
//                "shorts", "Adidas", 200, category, order, cart);

        p1.setCategory(category);
        p1.setProductName("Jeans");
        p1.setPrice(2000);
        p1.setColor("Black");
        p1.setSpecification("Shorts");
        p1.setQuantity(200);
        p1.setManufacturer("Adidas");
        p1.setOrder(order);
        p1.setCart(cart);
        adminService.addProduct(p1);
    }
}
