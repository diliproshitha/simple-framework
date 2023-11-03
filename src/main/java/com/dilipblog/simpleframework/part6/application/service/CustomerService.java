package com.dilipblog.simpleframework.part6.application.service;

import com.dilipblog.simpleframework.part6.application.model.Customer;

public interface CustomerService {

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
