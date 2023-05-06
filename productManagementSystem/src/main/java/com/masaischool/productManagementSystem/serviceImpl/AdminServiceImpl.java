package com.masaischool.productManagementSystem.serviceImpl;

import com.masaischool.productManagementSystem.dao.AdminDao;
import com.masaischool.productManagementSystem.daoImpl.AdminDaoImpl;
import com.masaischool.productManagementSystem.entity.Admin;
import com.masaischool.productManagementSystem.entity.Category;
import com.masaischool.productManagementSystem.entity.Product;
import com.masaischool.productManagementSystem.service.AdminService;
import com.masaischool.productManagementSystem.utils.DBUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AdminServiceImpl implements AdminService{

	@Override
	public boolean updatePassword(String newPassword,String username) throws Exception {
		AdminDao adminDao = new AdminDaoImpl();
		String password = adminDao.changePassword(newPassword,username);
		if(password == null || password.length() < 7){
			throw new Exception("minimum length of password shoud be 7");
		}
		return true;
	}

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
	public void addProduct(Product product) {
		EntityManager em = DBUtils.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(product.getCategory());
		et.commit();
		System.out.println("Product added successfully");
	}
}
