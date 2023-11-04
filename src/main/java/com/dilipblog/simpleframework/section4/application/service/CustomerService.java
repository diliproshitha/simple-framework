package com.dilipblog.simpleframework.section4.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dilipblog.simpleframework.section4.application.dao.CustomerDao;
import com.dilipblog.simpleframework.section4.application.model.Customer;

public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerDao customerDao;

    public CustomerService(final CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void createCustomer(final Customer customer) {
        logger.info("SERVICE:   START - create customer");
        customerDao.createCustomer(customer);
        logger.info("SERVICE:   END - create customer");
    }

    public void deleteCustomer(final Customer customer) {
        logger.info("SERVICE: START - delete customer");
        customerDao.createCustomer(customer);
        logger.info("SERVICE: END - delete customer");
    }

}
