package com.masaischool.productManagementSystem.service;

import com.masaischool.productManagementSystem.entity.User;

public interface UserService {

	public void changePassword(String password);
	public void signUp(User user);
}
