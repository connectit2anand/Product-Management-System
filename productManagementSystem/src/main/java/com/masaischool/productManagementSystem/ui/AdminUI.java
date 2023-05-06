package com.masaischool.productManagementSystem.ui;
import com.masaischool.productManagementSystem.service.AdminService;
import com.masaischool.productManagementSystem.serviceImpl.AdminServiceImpl;
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
                case 0:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Enter The Correct Choice");
            }
        } while(choice != 0);
    }

    private void resetPassword(Scanner sc) {
        System.out.println("Enter the username");
        String username = sc.next();
        System.out.println("Enter the new password");
        String password = sc.next();
        AdminService as = new AdminServiceImpl();
        as.resetPassword(username,password);
    }

    private void viewAllProducts(Scanner sc) {
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
        System.out.println("2. View All Products");
        System.out.println("3. Delete Product");
    }
}
