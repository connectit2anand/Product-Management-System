package com.masaischool.productManagementSystem.dao;

import com.masaischool.productManagementSystem.entity.Admin;
import com.masaischool.productManagementSystem.entity.Customer;

public interface CustomerDAO {
    Customer getCustomerByUserName(String newUserName);
    public void addNewCustomer(Customer customer);
    public Customer checkUserNamePassword(String userName, String password);
}
