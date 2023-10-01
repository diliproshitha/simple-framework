package com.dilipblog.simpleframework.part3.application.dao;

import com.dilipblog.simpleframework.part3.application.model.Customer;

public interface CustomerDao {

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
