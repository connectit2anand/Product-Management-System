package com.masaischool.productManagementSystem.serviceImpl;
import com.masaischool.productManagementSystem.dao.AdminDao;
import com.masaischool.productManagementSystem.dao.CustomerDAO;
import com.masaischool.productManagementSystem.daoImpl.CustomerDAOImpl;
import com.masaischool.productManagementSystem.entity.Customer;
import com.masaischool.productManagementSystem.entity.Orders;
import com.masaischool.productManagementSystem.entity.Product;
import com.masaischool.productManagementSystem.service.AdminService;
import com.masaischool.productManagementSystem.service.CustomerService;

import java.time.LocalDate;
import java.util.List;

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

    @Override
    public void updatePassword(Customer customer,String newPassword) {
        CustomerDAO cd = new CustomerDAOImpl();
        cd.updatePassword(customer,newPassword);
    }

    @Override
    public List<Product> getProduct() {
        CustomerDAO cd = new CustomerDAOImpl();
        List<Product> productList = cd.getProduct();
        return productList;
    }
    @Override
    public void purchaseOrder(int productId, int quantityOrdered,Customer customer) {
        AdminService as = new AdminServiceImpl();
        Product product =  as.getProductById(productId);
        if(product == null){
            System.out.println("Invalid product id");
            return;
        }
        //=======================================================================
        int quantityAvailable = product.getQuantity();
        if(quantityAvailable < quantityOrdered) {
            System.out.println("Sorry, Only " +quantityAvailable + " quantity is available" );
            return;
        }

        int totalQuantityLeft = quantityAvailable - quantityOrdered;
        product.setQuantity(totalQuantityLeft);

        CustomerDAO cd = new CustomerDAOImpl();
        cd.setNewQuantity(product);

        Orders orders = new Orders();
        double totalPrice = quantityOrdered * product.getPrice() + orders.getTotalOrderPrice();

        orders.setProductId(productId);
        orders.setQuantity(quantityOrdered);
        orders.setTotalOrderPrice(totalPrice);
        orders.setOrderDate(LocalDate.now());
        orders.setCustomer(customer);

        List<Orders> ordersList = customer.getOrders();
        ordersList.add(orders);

        customer.setOrders(ordersList);

        cd.purchaseOrder(customer);
        System.out.println("Your Order Has Been Successfully Placed");

    }

    @Override
    public void getCustomerOrderList(Customer customer) {
        CustomerDAO cd = new CustomerDAOImpl();
        List<Orders> ordersList = customer.getOrders();
        if(ordersList.size() == 0){
            System.out.println("Your Order List Is Empty");
            return;
        }
        ordersList.forEach(System.out :: println);
    }
}
