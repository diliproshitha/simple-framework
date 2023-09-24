package com.dilipblog.simpleframework.part1.service;

import com.dilipblog.simpleframework.part1.model.Customer;

public interface CustomerService {

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
