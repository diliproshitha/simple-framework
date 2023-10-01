package com.dilipblog.simpleframework.part4.application;

import com.dilipblog.simpleframework.part4.application.dao.CustomerDao;
import com.dilipblog.simpleframework.part4.application.model.Customer;
import com.dilipblog.simpleframework.part4.application.service.CustomerService;
import com.dilipblog.simpleframework.part4.framework.ProxyMethodInterceptor;

import net.sf.cglib.proxy.Enhancer;

public class Part4Application {
  public static void main(String[] args) {
    final Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(CustomerService.class);
    enhancer.setCallback(new ProxyMethodInterceptor());

    final CustomerService customerService = (CustomerService) enhancer
        .create(new Class[]{CustomerDao.class}, new Object[]{new CustomerDao()});
    customerService.createCustomer(new Customer());
  }
}
