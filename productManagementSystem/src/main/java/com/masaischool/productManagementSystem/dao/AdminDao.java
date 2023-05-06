package com.masaischool.productManagementSystem.dao;

import com.masaischool.productManagementSystem.entity.Admin;
//import com.masaischool.productManagementSystem.entity.Category;

public interface AdminDao {

    Admin getAdmin(String username);
    boolean resetPassword(String username, String password) throws Exception;
}
