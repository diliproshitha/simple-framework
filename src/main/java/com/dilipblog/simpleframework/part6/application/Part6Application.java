package com.dilipblog.simpleframework.part6.application;

import com.dilipblog.simpleframework.part6.application.model.Customer;
import com.dilipblog.simpleframework.part6.application.service.CustomerService;
import com.dilipblog.simpleframework.part6.framework.ApplicationContext;

public class Part6Application {
  public static void main(String[] args) {
    final ApplicationContext applicationContext = new ApplicationContext(Part6Application.class);
    final CustomerService customerService = applicationContext.getBean(CustomerService.class);
    customerService.createCustomer(new Customer());
  }
}
