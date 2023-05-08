package com.masaischool.productManagementSystem.dao;

import com.masaischool.productManagementSystem.entity.Admin;
import com.masaischool.productManagementSystem.entity.Customer;
import com.masaischool.productManagementSystem.entity.Orders;
import com.masaischool.productManagementSystem.entity.Product;

import java.util.List;

public interface CustomerDAO {
    Customer getCustomerByUserName(String newUserName);
    public void addNewCustomer(Customer customer);
    public Customer checkUserNamePassword(String userName, String password);
    void updatePassword(Customer customer, String newPassword);
    List<Product> getProduct();
    boolean addProductToBag(int productId, int quantity);

    void purchaseOrder(Customer customer);

    void setNewQuantity(Product product);

    List<Orders> getCustomerOrderList(Customer customer);
}
