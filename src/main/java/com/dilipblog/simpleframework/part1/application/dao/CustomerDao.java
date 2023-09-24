package com.dilipblog.simpleframework.part1.application.dao;

import com.dilipblog.simpleframework.part1.application.model.Customer;

public interface CustomerDao {

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
