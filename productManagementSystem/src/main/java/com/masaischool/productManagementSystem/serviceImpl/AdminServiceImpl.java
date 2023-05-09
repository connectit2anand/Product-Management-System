package com.masaischool.productManagementSystem.serviceImpl;

import com.masaischool.productManagementSystem.dao.AdminDao;
import com.masaischool.productManagementSystem.daoImpl.AdminDaoImpl;
import com.masaischool.productManagementSystem.entity.Admin;
import com.masaischool.productManagementSystem.entity.Category;
import com.masaischool.productManagementSystem.entity.Product;
import com.masaischool.productManagementSystem.service.AdminService;

import java.util.List;

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

	@Override
	public List<Category> getAllCategory() {
		AdminDao ad = new AdminDaoImpl();
		List<Category> categoryList =  ad.getAllCategory();
		return categoryList;
	}

	@Override
	public void addNewCategory(Category category) {
		AdminDao ad = new AdminDaoImpl();
		ad.addNewCategory(category);
	}

	@Override
	public List<Product> getAllProduct() {
		AdminDao ad = new AdminDaoImpl();
		List<Product> productList = ad.getAllProduct();
		return productList;
	}

	@Override
	public void updateProduct(Product product) {
		AdminDao ad = new AdminDaoImpl();
		ad.updateProduct(product);
	}

	@Override
	public Product getProductById(int productId) {
		AdminDao ad = new AdminDaoImpl();
		Product product = ad.getProductById(productId);
		return product;
	}

	@Override
	public void updateCategory(Category category) {
		AdminDao ad = new AdminDaoImpl();
		ad.updateCategory(category);

	}

	@Override
	public Category getCategoryById(int catId) {
		AdminDao ad = new AdminDaoImpl();
		return ad.getCategoryById(catId);
	}

	@Override
	public void deleteProduct(int productId) throws Exception {
		Product product = getProductById(productId);
		if(product == null) {
			throw new Exception("Invalid product id");
		}
		Category category = product.getCategory();
		List<Product> products = category.getProducts();
		for(int i = 0; i < products.size(); ++ i) {
			Product currentProduct = products.get(i);
			if(currentProduct.getProductId() == productId) {
				products.remove(i);
				break;
			}
		}
		category.setProducts(products);
		AdminDao dao = new AdminDaoImpl();
		dao.updateCategory(category);
		dao.deleteProduct(productId);
	}
}
