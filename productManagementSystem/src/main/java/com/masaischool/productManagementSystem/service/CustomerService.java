package com.masaischool.productManagementSystem.service;

import java.util.List;

import com.masaischool.productManagementSystem.entity.Customer;

public interface CustomerService {
	public void addCustomer(Customer cust);
	public void updateCustomer(Customer cust);
	public void removeCustomer(Customer cust);
	public Customer viewCustomer(Customer cust);
	public List<Customer> viewAllCustomers(String location);
}
