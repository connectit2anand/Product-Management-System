package com.masaischool.productManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	private Long id;
	private String userName;
	private String password;
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
}
