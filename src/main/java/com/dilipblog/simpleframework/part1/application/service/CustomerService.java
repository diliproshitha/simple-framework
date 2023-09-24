package com.dilipblog.simpleframework.part1.application.service;

import com.dilipblog.simpleframework.part1.application.model.Customer;

public interface CustomerService {

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
