package com.masaischool.productManagementSystem.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBUtils {
	
	static EntityManagerFactory emf = null;
	
	static {
		emf = Persistence.createEntityManagerFactory("projectConnect");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
