package com.masaischool.productManagementSystem.service;

import java.util.List;

import com.masaischool.productManagementSystem.entity.Customer;

public interface CustomerService {

    Customer getCustomerByUserName(String newUserName);

    void addNewCustomer(Customer customer);
    Customer checkUserNamePassword(String userName, String password);
}
