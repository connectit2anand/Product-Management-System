package com.masaischool.productManagementSystem.service;

public interface AdminService {

    boolean verifyCredential(String username, String password) throws Exception;

    void resetPassword(String username,String password);

}
