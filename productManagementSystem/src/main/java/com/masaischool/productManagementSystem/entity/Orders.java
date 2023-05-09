package com.masaischool.productManagementSystem.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
@Entity

public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private LocalDate orderDate;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	private int productId;
	private int quantity;
	private double totalOrderPrice;

	public Orders() {
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public void setTotalOrderPrice(double totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}

	@Override
	public String toString() {
		return "Orders{" +
				"orderId=" + orderId +
				", orderDate=" + orderDate +
				", customer=" + customer +
				", productId=" + productId +
				", quantity=" + quantity +
				", totalOrderPrice=" + totalOrderPrice +
				'}';
	}
}
