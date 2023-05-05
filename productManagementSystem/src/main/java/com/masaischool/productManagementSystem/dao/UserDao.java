package com.masaischool.productManagementSystem.dao;

import com.masaischool.productManagementSystem.entity.User;

public interface UserDao {
    public User getUserByUserName(String userName);
}
