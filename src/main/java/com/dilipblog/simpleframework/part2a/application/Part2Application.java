package com.dilipblog.simpleframework.part2a.application;

import java.lang.reflect.Proxy;

import com.dilipblog.simpleframework.part2a.application.dao.CustomerDao;
import com.dilipblog.simpleframework.part2a.application.dao.CustomerDaoImpl;
import com.dilipblog.simpleframework.part2a.application.model.Customer;
import com.dilipblog.simpleframework.part2a.application.service.CustomerService;
import com.dilipblog.simpleframework.part2a.application.service.CustomerServiceImpl;
import com.dilipblog.simpleframework.part2a.framework.ProxyHandler;

public class Part2Application {
  public static void main(String[] args) {
    final CustomerService customerService = getProxyInstance();
    customerService.createCustomer(new Customer());
  }

  private static CustomerService getProxyInstance() {
    final CustomerDao customerDao = new CustomerDaoImpl();
    return (CustomerService) Proxy.newProxyInstance(
        Part2Application.class.getClassLoader(),
        new Class[]{CustomerService.class},
        new ProxyHandler(new CustomerServiceImpl(customerDao))
    );
  }
}
