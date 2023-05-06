package com.masaischool.productManagementSystem.ui;

import com.masaischool.productManagementSystem.entity.Category;
import com.masaischool.productManagementSystem.entity.Customer;
import com.masaischool.productManagementSystem.entity.Orders;
import com.masaischool.productManagementSystem.entity.Product;
import com.masaischool.productManagementSystem.utils.DBUtils;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);
        AdminUI admin = new AdminUI();
        CustomerUI customer = new CustomerUI();
        int choice = -1;
        do {
            System.out.println("Welcome To Product Management System");
            System.out.println("1. Customer Service");
            System.out.println("2. Admin Service");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            switch (choice){
                case 1 :
                    customer.customermMain(sc);
                    break;
                case 2 :
                    admin.adminMain(sc);
                    break;
                case 0 :
                    System.out.println("Thank You ");
                default:
                    System.out.println("Enter The Correct Choice");
            }

        } while (choice != 0);

    }
}
