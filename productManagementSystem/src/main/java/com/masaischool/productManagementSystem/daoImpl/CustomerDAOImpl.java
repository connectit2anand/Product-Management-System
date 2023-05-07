package com.masaischool.productManagementSystem.daoImpl;
import com.masaischool.productManagementSystem.dao.CustomerDAO;
import com.masaischool.productManagementSystem.entity.Customer;
import com.masaischool.productManagementSystem.utils.DBUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;


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
}
