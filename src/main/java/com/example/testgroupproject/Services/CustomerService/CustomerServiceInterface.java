package com.example.testgroupproject.Services.CustomerService;


import com.example.testgroupproject.Models.CustomerGuest;

import java.util.List;

public interface CustomerServiceInterface {

    void insertCustomer(CustomerGuest c);

    List<CustomerGuest> getAllCustomers();

    CustomerGuest getCustomerById(Integer id);

    void deleteCustomer(CustomerGuest c);

    void updateCustomer(CustomerGuest c);

    CustomerGuest findByCusUsername(String name);

}
