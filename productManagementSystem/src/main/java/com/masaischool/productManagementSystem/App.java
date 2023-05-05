package com.masaischool.productManagementSystem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
//        System.out.println("Hello world");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectConnect");
        EntityManager em =  emf.createEntityManager();
    }
}
