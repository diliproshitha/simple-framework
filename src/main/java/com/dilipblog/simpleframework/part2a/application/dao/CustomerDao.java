package com.dilipblog.simpleframework.part2a.application.dao;

import com.dilipblog.simpleframework.part2a.application.model.Customer;

public interface CustomerDao {

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
