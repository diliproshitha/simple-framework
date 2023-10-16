package com.dilipblog.simpleframework.part5.application;

import com.dilipblog.simpleframework.part5.application.model.Customer;
import com.dilipblog.simpleframework.part5.application.service.CustomerService;
import com.dilipblog.simpleframework.part5.framework.ApplicationContext;

public class Part5Application {
  public static void main(String[] args) {
    final ApplicationContext applicationContext = new ApplicationContext(Part5Application.class);
    final CustomerService customerService = applicationContext.getBean(CustomerService.class);
    customerService.createCustomer(new Customer());
  }
}
