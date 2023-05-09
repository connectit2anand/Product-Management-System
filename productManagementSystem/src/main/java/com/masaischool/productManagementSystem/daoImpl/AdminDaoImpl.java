package com.masaischool.productManagementSystem.daoImpl;
import com.masaischool.productManagementSystem.dao.AdminDao;
import com.masaischool.productManagementSystem.entity.Admin;
import com.masaischool.productManagementSystem.entity.Category;
import com.masaischool.productManagementSystem.entity.Product;
import com.masaischool.productManagementSystem.utils.DBUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;


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

    @Override
    public List<Category> getAllCategory() {
        EntityManager em = DBUtils.getEntityManager();
        String q = "SELECT c FROM Category c";
        Query query = em.createQuery(q);
        List<Category> categoryList = query.getResultList();
        return categoryList;
    }

    @Override
    public void addNewCategory(Category category) {
        EntityManager em = DBUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(category);
        et.commit();
        em.close();
    }

    @Override
    public List<Product> getAllProduct() {
        EntityManager em = DBUtils.getEntityManager();
        String q = "SELECT p FROM Product p";
        Query query = em.createQuery(q);
        List<Product> productList = query.getResultList();
        return productList;
    }

    @Override
    public void updateProduct(Product product) {
        EntityManager em = DBUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(product);
        et.commit();
        em.close();
    }
    @Override
    public Product getProductById(int productId) {
        EntityManager em = DBUtils.getEntityManager();
        Product product = em.find(Product.class,productId);
        if(product == null){
            return null;
        }
        return product;
    }

    @Override
    public void updateCategory(Category category) {
        EntityManager em = DBUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(category);
        et.commit();
        em.close();
    }

    @Override
    public Category getCategoryById(int catId) {
        EntityManager em = DBUtils.getEntityManager();
        Category categroy = em.find(Category.class,catId);
        em.close();
        return categroy;
    }

    @Override
    public void deleteProduct(int productId) {
        String q = "delete from Product p where p.productId =: id";
        EntityManager em = DBUtils.getEntityManager();
        Query query = em.createQuery(q);
        query.setParameter("id", productId);
        EntityTransaction et = em.getTransaction();
        et.begin();
        query.executeUpdate();
        et.commit();
    }
}
