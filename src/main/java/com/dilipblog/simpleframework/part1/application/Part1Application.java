package com.dilipblog.simpleframework.part1.application;

import com.dilipblog.simpleframework.part1.application.dao.CustomerDao;
import com.dilipblog.simpleframework.part1.application.dao.CustomerDaoImpl;
import com.dilipblog.simpleframework.part1.application.model.Customer;
import com.dilipblog.simpleframework.part1.application.service.CustomerService;
import com.dilipblog.simpleframework.part1.application.service.CustomerServiceImpl;

public class Part1Application {
  public static void main(String[] args) {
    final CustomerDao customerDao = new CustomerDaoImpl();
    final CustomerService customerService = new CustomerServiceImpl(customerDao);

    customerService.createCustomer(new Customer());
  }
}
