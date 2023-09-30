package com.dilipblog.simpleframework.part2a.application.service;

import com.dilipblog.simpleframework.part2a.application.model.Customer;

public interface CustomerService {

    void createCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
