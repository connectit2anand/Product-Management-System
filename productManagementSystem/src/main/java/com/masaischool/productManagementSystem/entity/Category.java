package com.masaischool.productManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int catId;
	@Column(name = "category_name")
	private String categoryName;

	public Category(String categoryName, Set<Product> products) {
		this.categoryName = categoryName;
		this.products = products;
	}

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	Set<Product> products;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}



}
