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
	@Column(name = "product_id")
	private int productId;
	@Column(name = "product_name")
	private String productName;
	private double price;
	private String color;
	private String specification;
	private String manufacturer;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	@ManyToOne
	private Orders order;

	@ManyToOne
	private Cart cart;

}
