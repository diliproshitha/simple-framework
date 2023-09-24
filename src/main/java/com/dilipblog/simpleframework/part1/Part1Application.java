package com.dilipblog.simpleframework.part1;

import com.dilipblog.simpleframework.part1.dao.CustomerDao;
import com.dilipblog.simpleframework.part1.dao.CustomerDaoImpl;
import com.dilipblog.simpleframework.part1.model.Customer;
import com.dilipblog.simpleframework.part1.service.CustomerService;
import com.dilipblog.simpleframework.part1.service.CustomerServiceImpl;

public class Part1Application {
  public static void main(String[] args) {
    final CustomerDao customerDao = new CustomerDaoImpl();
    final CustomerService customerService = new CustomerServiceImpl(customerDao);

    customerService.createCustomer(new Customer());
  }
}
