package com.masaischool.productManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int productId;

	private String productName;
	private double price;
	private String color;
	private String specification;
	private String manufacturer;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;


	public Product(String productName, double price, String color, String specification, String manufacturer, int quantity) {
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
	}
}
