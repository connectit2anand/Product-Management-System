package com.masaischool.productManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int customerId;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Orders> order;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Address> address;
	private String email;
}
