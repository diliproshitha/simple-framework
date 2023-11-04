package com.dilipblog.simpleframework.section5.application.service;

import com.dilipblog.simpleframework.section5.application.model.Customer;

public interface CustomerService {

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
