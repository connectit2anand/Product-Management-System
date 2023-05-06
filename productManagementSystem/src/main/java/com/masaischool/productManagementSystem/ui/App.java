package com.masaischool.productManagementSystem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class App {

    public static void main( String[] args ){

        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("Welcome To Product Management System");
            System.out.println("1. Customer Service");
            System.out.println("2. Admin Service");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            switch (choice){
                case 1 :
                    customerService();
                    break;
                case 2 :
                    adminService();
                    break;
                case 0 :
                    System.out.println("Thank You ");
                default:
                    System.out.println("Enter The Correct Choice");
            }

        } while (choice != 0);

    }

    private static void adminService() {
        
    }

    private static void customerService() {
    }
}
