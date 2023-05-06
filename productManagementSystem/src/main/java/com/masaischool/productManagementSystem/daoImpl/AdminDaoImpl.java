package com.masaischool.productManagementSystem.daoImpl;

import com.masaischool.productManagementSystem.dao.AdminDao;
import com.masaischool.productManagementSystem.entity.Admin;
import com.masaischool.productManagementSystem.entity.Category;
import com.masaischool.productManagementSystem.entity.Product;
import com.masaischool.productManagementSystem.utils.DBUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


public class AdminDaoImpl implements AdminDao{

    @Override
    public Admin getAdmin(String username) {
        EntityManager em = DBUtils.getEntityManager();
        Query query = em.createNamedQuery("getAdminByUserName");
        query.setParameter("username",username);
        try {
            Admin admin = (Admin) query.getSingleResult();
            return admin;
        } catch (Exception e) {}
        return null;
    }

    @Override
    public String changePassword(String newPassword,String username) throws Exception {
        Admin admin = getAdmin(username);
        if(admin == null){
            throw new Exception("Invalid credential");
        }
        EntityManager em = DBUtils.getEntityManager();
        String q = "UPDATE Admin a SET password = :newPass WHERE username = :user";
        Query query = em.createNamedQuery(q);
        query.setParameter("newPass","newPassword");
        query.setParameter("user","username");
        String pass = (String)query.getSingleResult();
        return pass;
    }

    @Override
    public void addProduct(double price,String color, String specification, String manufacturer, int quantity, Category category) {
        Category category1 = new Category();
        Product product = new Product();
        product.setPrice(200.0);
        product.setColor("pink");
        product.setSpecification("specification");
        product.setManufacturer("manufacturer");
        product.setQuantity(12);
        product.setCategory(category1);
    }
}
