package com.masaischool.productManagementSystem.service;

import java.util.List;

import com.masaischool.productManagementSystem.entity.Customer;
import com.masaischool.productManagementSystem.entity.Product;

public interface CustomerService {

    Customer getCustomerByUserName(String newUserName);

    void addNewCustomer(Customer customer);
    Customer checkUserNamePassword(String userName, String password);

    void updatePassword(Customer customer,String newPassword);

    List<Product> getProduct();
    void purchaseOrder(int productId, int quantity,Customer customer);

    void getCustomerOrderList(Customer customer);
}
