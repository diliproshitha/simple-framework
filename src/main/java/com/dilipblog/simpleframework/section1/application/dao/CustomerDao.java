package com.dilipblog.simpleframework.section1.application.dao;

import com.dilipblog.simpleframework.section1.application.model.Customer;

public interface CustomerDao {

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
