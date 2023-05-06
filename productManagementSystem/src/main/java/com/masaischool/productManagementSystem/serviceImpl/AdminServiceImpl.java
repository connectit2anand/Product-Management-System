package com.masaischool.productManagementSystem.serviceImpl;

import com.masaischool.productManagementSystem.dao.AdminDao;
import com.masaischool.productManagementSystem.daoImpl.AdminDaoImpl;
import com.masaischool.productManagementSystem.entity.Admin;
import com.masaischool.productManagementSystem.service.AdminService;

public class AdminServiceImpl implements AdminService{

	@Override
	public boolean verifyCredential(String username, String password) throws Exception {
		AdminDao adminDao = new AdminDaoImpl();
		Admin admin = adminDao.getAdmin(username);
		if(admin == null) {
			throw new Exception("Invalid Credentials");
		}
		String dbPassowrd = admin.getPassword();
		if(!password.equals(dbPassowrd)) {
			throw new Exception("Invalid Credentials");
		}
		return true;
	}

	@Override
	public void resetPassword(String username, String password) {
		AdminDao ad = new AdminDaoImpl();
		try {
			boolean isPasswordChanged =  ad.resetPassword(username, password);
			System.out.println("Password changed successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}

	}


}
