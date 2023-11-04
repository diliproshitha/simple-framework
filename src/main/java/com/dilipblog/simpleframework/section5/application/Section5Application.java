package com.dilipblog.simpleframework.section5.application;

import com.dilipblog.simpleframework.section5.application.model.Customer;
import com.dilipblog.simpleframework.section5.application.service.CustomerService;
import com.dilipblog.simpleframework.section5.framework.ApplicationContext;

public class Section5Application {
  public static void main(String[] args) {
    final ApplicationContext applicationContext = new ApplicationContext(Section5Application.class);
    final CustomerService customerService = applicationContext.getBean(CustomerService.class);
    customerService.createCustomer(new Customer());
  }
}
