package com.masaischool.productManagementSystem.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private LocalDate date;
	private String orderStatus;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	@OneToMany
	private Set<Product> productList;

}
