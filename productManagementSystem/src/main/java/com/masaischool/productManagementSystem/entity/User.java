package com.masaischool.productManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String password;
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
}
