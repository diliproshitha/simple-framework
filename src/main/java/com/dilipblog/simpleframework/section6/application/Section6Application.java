package com.dilipblog.simpleframework.section6.application;

import com.dilipblog.simpleframework.section6.application.model.Customer;
import com.dilipblog.simpleframework.section6.application.service.CustomerService;
import com.dilipblog.simpleframework.section6.framework.ApplicationContext;

public class Section6Application {
  public static void main(String[] args) {
    final ApplicationContext applicationContext = new ApplicationContext(Section6Application.class);
    final CustomerService customerService = applicationContext.getBean(CustomerService.class);
    customerService.createCustomer(new Customer());
  }
}
