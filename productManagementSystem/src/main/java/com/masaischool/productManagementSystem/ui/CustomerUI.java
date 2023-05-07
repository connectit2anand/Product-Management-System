package com.masaischool.productManagementSystem.ui;
import com.masaischool.productManagementSystem.entity.Customer;
import com.masaischool.productManagementSystem.entity.Orders;
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
                case 0:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Enter The Correct Choice");
            }
        } while(choice != 0);
    }

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
        //add functionality after login.
    }

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

    private void printAdminMenu() {
        System.out.println("1. Create New Account");
        System.out.println("2. Login");
        System.out.println("3. Reset Password");
    }


}
