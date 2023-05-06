package com.masaischool.productManagementSystem.service;

import java.time.LocalDate;
import java.util.List;

import com.masaischool.productManagementSystem.entity.Orders;

public interface OrderService {
	public void addOrder(Orders order);
	public void updateOrder(Orders order);
	public void removeOrder(Orders order);
	public List<Orders> viewOrder(Orders order);
	public List<Orders> viewAllOrders(LocalDate date);
	public void viewAllOrdersByLocation(String loc);
	public void viewAllOrdersByUserId(String userId);


}
