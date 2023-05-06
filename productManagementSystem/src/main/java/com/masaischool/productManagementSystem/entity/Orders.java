package com.masaischool.productManagementSystem.entity;

import java.time.LocalDate;
import java.util.List;
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
	private LocalDate orderDate;

	@ManyToOne
	@JoinColumn(name = "curstomer_id")
	private Customer customer;
	private int productId;
	private int quantity;
	private int totalOrderPrice;

}
