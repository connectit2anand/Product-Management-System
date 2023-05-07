package com.masaischool.productManagementSystem.entity;

import java.util.List;
import java.util.Set;
import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;
	@Column(name = "category_name")
	private String categoryName;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	List<Product> products;



	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category{" +
				"catId=" + catId +
				", categoryName='" + categoryName ;
	}

}
