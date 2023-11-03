package com.dilipblog.simpleframework.part6.application.dao;

import com.dilipblog.simpleframework.part6.application.model.Customer;

public interface CustomerDao {

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
