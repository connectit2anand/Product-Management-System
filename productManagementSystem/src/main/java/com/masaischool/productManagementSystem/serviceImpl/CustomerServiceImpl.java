package com.masaischool.productManagementSystem.serviceImpl;
import com.masaischool.productManagementSystem.dao.CustomerDAO;
import com.masaischool.productManagementSystem.daoImpl.CustomerDAOImpl;
import com.masaischool.productManagementSystem.entity.Customer;
import com.masaischool.productManagementSystem.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer getCustomerByUserName(String newUserName) {
        CustomerDAO cd = new CustomerDAOImpl();
        Customer customer = cd.getCustomerByUserName(newUserName);
        return customer;
    }

    @Override
    public void addNewCustomer(Customer customer) {
        CustomerDAO cd = new CustomerDAOImpl();
        cd.addNewCustomer(customer);
    }

    @Override
    public Customer checkUserNamePassword(String userName, String password) {
        CustomerDAO cd = new CustomerDAOImpl();
        return cd.checkUserNamePassword(userName,password);

    }
}
