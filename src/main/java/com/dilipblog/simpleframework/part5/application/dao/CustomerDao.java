package com.dilipblog.simpleframework.part5.application.dao;

import com.dilipblog.simpleframework.part5.application.model.Customer;

public interface CustomerDao {

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
