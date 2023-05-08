package com.masaischool.productManagementSystem.daoImpl;
import com.masaischool.productManagementSystem.dao.CustomerDAO;
import com.masaischool.productManagementSystem.entity.Customer;
import com.masaischool.productManagementSystem.entity.Orders;
import com.masaischool.productManagementSystem.entity.Product;
import com.masaischool.productManagementSystem.utils.DBUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;


public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public Customer getCustomerByUserName(String newUserName) {
        EntityManager em = DBUtils.getEntityManager();
        Query query = em.createNamedQuery("checkCustomerUserName");
        query.setParameter("username","newUserName");
        Customer c = null;
        try {
             c = (Customer) query.getSingleResult();
             return c;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void addNewCustomer(Customer customer) {
        EntityManager em = DBUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(customer);
        et.commit();
    }

    @Override
    public Customer checkUserNamePassword(String userName, String password) {
        EntityManager em = DBUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        Query query = em.createNamedQuery("isUserNamePasswordCorrect");
        query.setParameter("user",userName);
        query.setParameter("pass",password);
        Customer customer = null;
        try{
            customer = (Customer) query.getSingleResult();
        } catch(Exception e){
            return null;
        }
        return customer;
    }

    @Override
    public void updatePassword(Customer customer, String newPassword) {
        EntityManager em = DBUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        customer.setPassword(newPassword);
        et.begin();
        em.merge(customer);
        et.commit();
        em.close();

    }

    @Override
    public List<Product> getProduct() {
        EntityManager em = DBUtils.getEntityManager();
        Query query = em.createNamedQuery("getProductList");
        List<Product> productList =  query.getResultList();
        return productList;
    }

    @Override
    public boolean addProductToBag(int productId, int quantity) {
        EntityManager em = DBUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        return false;
    }

    @Override
    public void purchaseOrder(Customer customer) {
        EntityManager em = DBUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(customer);
        et.commit();
    }

    @Override
    public void setNewQuantity(Product product) {
        EntityManager em = DBUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(product);
        et.commit();
    }

    @Override
    public List<Orders> getCustomerOrderList(Customer customer) {
        return customer.getOrders();
    }
}
