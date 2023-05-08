package com.masaischool.productManagementSystem.entity;

import jakarta.persistence.*;


@NamedNativeQuery(name="getProductList",query="SELECT * FROM Product",resultClass = Product.class)
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


	public Product(String productName, double price, String color, String specification,
				   String manufacturer, int quantity, Category category) {
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.category = category;
	}

	public Product() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", productName='" + productName + '\'' +
				", price=" + price +
				", color='" + color + '\'' +
				", specification='" + specification + '\'' +
				", manufacturer='" + manufacturer + '\'' +
				", quantity=" + quantity +
				", category=" + category +
				'}';
	}
}
