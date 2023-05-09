package com.masaischool.productManagementSystem.ui;
import com.masaischool.productManagementSystem.entity.Admin;
import com.masaischool.productManagementSystem.entity.Category;
import com.masaischool.productManagementSystem.entity.Product;
import com.masaischool.productManagementSystem.service.AdminService;
import com.masaischool.productManagementSystem.serviceImpl.AdminServiceImpl;
import com.masaischool.productManagementSystem.utils.DBUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AdminUI {

    public void adminMain(Scanner sc) {
        boolean verify = login(sc);
        if(!verify){
            return;
        }
        int choice = -1;
        do{
            System.out.println("Choose Your Option");
            printAdminMenu();
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    resetPassword(sc);
                    break;
                case 2:
                    addProduct(sc);
                    break;
                case 3:
                    viewCategoryList();
                    break;
                case 4:
                    viewAllProducts();
                    break;
                case 5:
                    updateProduct(sc);
                    break;
                case 6:
                    deleteProduct(sc);
                    break;
                case 0:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Enter The Correct Choice");
            }
        } while(choice != 0);
    }

    private void deleteProduct(Scanner sc) {
        AdminService service = new AdminServiceImpl();
        List<Product> productList = service.getAllProduct();
        productList.forEach(System.out :: println);
        System.out.println("Enter the product id which you want to delete");
        int productId = sc.nextInt();
        try {
            service.deleteProduct(productId);
            System.out.println("Product with id " + productId + " successfully deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewCategoryList() {
        AdminService as = new AdminServiceImpl();
        List<Category> categoryList = as.getAllCategory();
        if(categoryList == null || categoryList.size() == 0){
            System.out.println("No Category Found");
            return;
        }
        for(Category c : categoryList){
            System.out.println(c);
        }
    }

    private void addProduct(Scanner sc) {
        AdminService as = new AdminServiceImpl();
        List<Category> categoryList = as.getAllCategory();
        if(categoryList == null || categoryList.size() == 0){
            System.out.println("1 Add New Category");
        } else {
            for(Category c : categoryList){
                System.out.println("Id: " + c.getCatId() + " name " + c.getCategoryName());
            }
            System.out.println("1 Add Product in New Category");
            System.out.println("2 Add Product in Existing Category");
        }
        addOrUpdate(sc);
    }

    private void addOrUpdate(Scanner sc) {
        System.out.println("Enter Your Choice");
        int n = sc.nextInt();
        if(n == 1) addNewProduct(sc);
        if(n == 2) addNewProductInExistingCategory(sc);
    }

    private void addNewProductInExistingCategory(Scanner sc) {
        AdminService service = new AdminServiceImpl();
        System.out.println("Enter the category id in which you want to add product.");
        int catId = sc.nextInt();
        Category category = service.getCategoryById(catId);
        if(category == null) {
            System.out.println("Invalid category id");
            return;
        }
        List<Product> productList = category.getProducts();
        System.out.println("How many products you want to add in category_id " + catId);
        int numberOfNewProducts = sc.nextInt();
        for(int i = 0; i < numberOfNewProducts; i ++){
            System.out.println("Enter the product name");
            String productName = sc.next();
            System.out.println("Enter the price");
            double  price = sc.nextDouble();
            System.out.println("Enter the color");
            String color = sc.next();
            System.out.println("Enter the specification");
            String specification = sc.next();
            System.out.println("Enter the manufacturer");
            String manufacturer = sc.next();
            System.out.println("Enter the quantity");
            int quantity = sc.nextInt();
            productList.add(new Product(productName,price,color,specification,manufacturer,quantity, category));
        }
        service.updateCategory(category);
    }

    private void updateProduct(Scanner sc) {
        AdminService as = new AdminServiceImpl();
        List<Product> products = as.getAllProduct();
        if(products == null || products.size() == 0) {
            System.out.println("Product not available");
            return;
        }
        products.forEach(System.out :: println);
        System.out.println("Please select product id which you want to update");
        int productId = sc.nextInt();
        Product product = as.getProductById(productId);
        if(product == null){
            System.out.println("Invalid product id.");
            return;
        }
        System.out.println("Enter new product name");
        String productName = sc.next();
        product.setProductName(productName);

        System.out.println("Enter new price");
        double price = sc.nextDouble();
        product.setPrice(price);

        System.out.println("Enter new color");
        String color = sc.next();
        product.setColor(color);

        System.out.println("Enter new specification");
        String specification = sc.next();
        product.setSpecification(specification);

        System.out.println("Enter new manufacturer");
        String manufacturer = sc.next();
        product.setManufacturer(manufacturer);

        System.out.println("Enter new quantity");
        int quantity = sc.nextInt();
        product.setQuantity(quantity);
        as.updateProduct(product);
        System.out.println("Product Successfully updated");
    }

    private void addNewProduct(Scanner sc) {

        Category category = new Category();
        System.out.println("Enter the category name");
        String categoryName = sc.next();
        List<Product> productList = new ArrayList<>();
        System.out.println("How many new products do you want to add ?");
        int numberOfNewProducts = sc.nextInt();
        for(int i = 0; i < numberOfNewProducts; i ++){
            System.out.println("Enter the product name");
            String productName = sc.next();
            System.out.println("Enter the price");
            double  price = sc.nextDouble();
            System.out.println("Enter the color");
            String color = sc.next();
            System.out.println("Enter the specification");
            String specification = sc.next();
            System.out.println("Enter the manufacturer");
            String manufacturer = sc.next();
            System.out.println("Enter the quantity");
            int quantity = sc.nextInt();
            productList.add(new Product(productName,price,color,specification,manufacturer,quantity, category));
        }
        category.setCategoryName(categoryName);
        category.setProducts(productList);
        AdminService as = new AdminServiceImpl();
        as.addNewCategory(category);
    }

    private void resetPassword(Scanner sc) {
        System.out.println("Enter the username");
        String username = sc.next();
        System.out.println("Enter the new password");
        String password = sc.next();
        AdminService as = new AdminServiceImpl();
        as.resetPassword(username,password);
    }

    private void viewAllProducts() {
        AdminService as = new AdminServiceImpl();
        List<Product> productList = as.getAllProduct();
        if(productList == null){
            System.out.println("No Product Found");
            return;
        }
        for(Product p : productList){
            System.out.println(p);
        }
    }

    private boolean login(Scanner sc) {
        System.out.println("Enter the username");
        String username = sc.next();
        System.out.println("Enter the password");
        String password = sc.next();
        AdminService as = new AdminServiceImpl();
        try {
            boolean check = as.verifyCredential(username,password);
            System.out.println("Successfully logged in");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void printAdminMenu() {
        System.out.println("1. Reset Password");
        System.out.println("2. Add product");
        System.out.println("3. View Category List");
        System.out.println("4. View All Products");
        System.out.println("5. Update Product");
        System.out.println("6. Delete Product");
    }
}
