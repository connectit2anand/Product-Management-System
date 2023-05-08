package com.masaischool.productManagementSystem.ui;
import com.masaischool.productManagementSystem.entity.Category;
import com.masaischool.productManagementSystem.entity.Customer;
import com.masaischool.productManagementSystem.entity.Orders;
import com.masaischool.productManagementSystem.entity.Product;
import com.masaischool.productManagementSystem.service.AdminService;
import com.masaischool.productManagementSystem.service.CustomerService;
import com.masaischool.productManagementSystem.serviceImpl.AdminServiceImpl;
import com.masaischool.productManagementSystem.serviceImpl.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerUI {

    public void customermMain(Scanner sc) {

        int choice = -1;
        do{
            System.out.println("Choose Your Option");
            printAdminMenu();
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    signUp(sc);
                    break;
                case 2:
                    login(sc);
                    break;
                case 3:
                    resetPassword(sc);
                    break;
                case 0:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Enter The Correct Choice");
            }
        } while(choice != 0);
    }
//===============================================================
    private void resetPassword(Scanner sc) {
        System.out.println("Enter User Name");
        String username = sc.next();
        System.out.println("Enter Old Password");
        String password = sc.next();
        CustomerService cs = new CustomerServiceImpl();
        Customer customer =  cs.checkUserNamePassword(username,password);
        if(customer == null){
            System.out.println("Invalid Credential");
            return;
        }
        System.out.println("Enter New Password");
        String newPassword = sc.next();
        cs.updatePassword(customer,newPassword);
        System.out.println("Password changed successfully");
    }
//=================================================================
    private void login(Scanner sc) {
        System.out.println("Enter User Name");
        String userName = sc.next();
        System.out.println("Enter Password");
        String password = sc.next();
        CustomerService cs = new CustomerServiceImpl();
        Customer customer = cs.checkUserNamePassword(userName,password);
        if(customer == null){
            System.out.println("Invalid Credential");
            return;
        }
        System.out.println("Successfully Logged In");
        printMenuAfterLogin(sc,customer);
    }

    private void printMenuAfterLogin(Scanner sc,Customer customer) {
        int choice = -1;
        do{
            displayMenuForCustomer();
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    showAllProducts(customer, sc);
                    break;
                case 2:
                    showAllCategories(customer, sc);
                    break;
                case 3:
                    showOrderList(customer);
                    break;
                case 0:
                    System.out.println("Thank You, you are successfully logged out");
                    break;
                default :
                    System.out.println("Please Enter Valid Choice");
            }
        } while(choice != 0);
    }

    private void showOrderList(Customer customer) {
        CustomerService cs = new CustomerServiceImpl();
        cs.getCustomerOrderList(customer);
    }

    private void showAllCategories(Customer customer, Scanner sc) {
        AdminService as = new AdminServiceImpl();
        List<Category> categoryList = as.getAllCategory();
        if (categoryList == null) {
            System.out.println("No products available");
        }

        for (Category c : categoryList) {
            if (c.getProducts() == null || c.getProducts().size() == 0) {
                continue;
            }
            System.out.println("========================================");
            System.out.println("Category " + c.getCategoryName() + " contains following products");
            System.out.println("========================================");
            List<Product> products = c.getProducts();
            products.forEach(System.out :: println);
            System.out.println();
            System.out.println("===============================================");
        }
        purchaseProduct(customer, sc);
    }

    private void showAllProducts(Customer customer, Scanner sc) {
        CustomerService cs = new CustomerServiceImpl();
        List<Product> productList = cs.getProduct();
        if(productList == null){
            System.out.println("No Products Available");
        }
        System.out.println("==============================================================");
        productList.forEach(System.out :: println);
        System.out.println("==============================================================");
        purchaseProduct(customer, sc);
    }

    private void purchaseProduct(Customer customer, Scanner sc) {
        getListOfProductOfCustomer(sc,customer);
    }

    private void getListOfProductOfCustomer(Scanner sc,Customer customer) {
        int choice = -1;
        while(choice != 0){
            System.out.println("Enter the product id of the product you want to purchase");
            int productId = sc.nextInt();
            System.out.println("Enter the quantity of the product");
            int quantity = sc.nextInt();
            CustomerService cs = new CustomerServiceImpl();
            cs.purchaseOrder(productId,quantity,customer);
            System.out.println("Enter Zero To Exit or any other number to continue shopping");
            choice = sc.nextInt();
        }
    }


    private void displayMenuForCustomer() {
        System.out.println("1. Show All Products");
        System.out.println("2. Show All Product based on Categories");
        System.out.println("3. Show Order details");
        System.out.println("0. To logout.");
    }

    //=========================================================================
    private void signUp(Scanner sc) {

        String newUserName =  createNewUserName(sc);

        System.out.println("Enter Password");
        String password = sc.next();

        System.out.println("Enter First Name");
        String firstName = sc.next();

        System.out.println("Enter Last Name");
        String lastName = sc.next();

        System.out.println("Enter phoneNumber");
        String phoneNumber = sc.next();

        System.out.println("Enter Email");
        String email = sc.next();

        Customer customer = new Customer();
        customer.setUsername(newUserName);
        customer.setPassword(password);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);

        List<Orders> ordersList = new ArrayList<>();
        customer.setOrders(ordersList);
        CustomerService cs = new CustomerServiceImpl();
        cs.addNewCustomer(customer);
    }
//========================================================================
    private String createNewUserName(Scanner sc) {
        boolean isNew = true;
        while(isNew){
            System.out.println("Enter The User Name");
            String newUserName = sc.next();
            CustomerService cs = new CustomerServiceImpl();
            Customer customer = cs.getCustomerByUserName(newUserName);
            if(customer == null) return newUserName;
            else System.out.println("User Name Already Exist");
        }
        return "";
    }
//======================================================
    private void printAdminMenu() {
        System.out.println("1. Create New Account");
        System.out.println("2. Login");
        System.out.println("3. Reset Password");
        System.out.println("0. Exit");
    }
}
//========================================================