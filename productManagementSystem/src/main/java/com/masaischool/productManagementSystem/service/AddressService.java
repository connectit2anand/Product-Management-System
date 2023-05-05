package com.masaischool.productManagementSystem.service;

import com.masaischool.productManagementSystem.entity.Address;

public interface AddressService {
	public void addAddress(Address add);
	public void updateAddress(Address add);
	public void removeAddress(Address add);
	public void viewAllAddress(String id);
	public void viewAllAddress(Address add);
}
