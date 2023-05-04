package com.masaischool.productManagementSystem;

import com.masaischool.productManagementSystem.utils.DbUtils;

import jakarta.persistence.EntityManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManager em = DbUtils.getEntityManager();
        System.out.println( "Welcome To Product Management System." );
    }
}
