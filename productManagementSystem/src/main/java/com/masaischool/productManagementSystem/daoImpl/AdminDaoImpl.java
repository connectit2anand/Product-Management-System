package com.masaischool.productManagementSystem.daoImpl;

import com.masaischool.productManagementSystem.dao.AdminDao;
import com.masaischool.productManagementSystem.entity.Admin;
import com.masaischool.productManagementSystem.utils.DBUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
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
        finally {
            em.close();
        }
        return null;
    }
    @Override
    public boolean resetPassword(String username, String password) throws Exception {
        Admin admin = null;
       try{
           admin = getAdmin(username);
       } catch(Exception e){
           throw new Exception("Invalid Credential");
       }
       if(admin == null){
           throw new Exception("Invalid Credential");
       }
        admin.setPassword(password);
        EntityManager em = DBUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(admin);
        et.commit();
        return true;
    }
}
