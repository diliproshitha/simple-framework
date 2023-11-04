package com.dilipblog.simpleframework.section3.application;

import java.lang.reflect.Proxy;

import com.dilipblog.simpleframework.section3.application.dao.CustomerDao;
import com.dilipblog.simpleframework.section3.application.dao.CustomerDaoImpl;
import com.dilipblog.simpleframework.section3.application.model.Customer;
import com.dilipblog.simpleframework.section3.application.service.CustomerService;
import com.dilipblog.simpleframework.section3.application.service.CustomerServiceImpl;
import com.dilipblog.simpleframework.section3.framework.ProxyHandler;

public class Section3Application {
  public static void main(String[] args) {
    final CustomerService customerService = getProxyInstance();
    customerService.createCustomer(new Customer());
  }

  private static CustomerService getProxyInstance() {
    final CustomerDao customerDao = new CustomerDaoImpl();
    return (CustomerService) Proxy.newProxyInstance(
        Section3Application.class.getClassLoader(),
        new Class[]{CustomerService.class},
        new ProxyHandler(new CustomerServiceImpl(customerDao))
    );
  }
}
