package com.dilipblog.simpleframework.part1.dao;

import com.dilipblog.simpleframework.part1.model.Customer;

public interface CustomerDao {

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
