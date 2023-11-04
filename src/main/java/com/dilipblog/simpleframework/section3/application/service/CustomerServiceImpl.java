package com.dilipblog.simpleframework.section3.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dilipblog.simpleframework.section3.application.dao.CustomerDao;
import com.dilipblog.simpleframework.section3.application.model.Customer;

public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerDao customerDao;

    public CustomerServiceImpl(final CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void createCustomer(final Customer customer) {
        logger.info("SERVICE:   START - create customer");
        customerDao.createCustomer(customer);
        logger.info("SERVICE:   END - create customer");
    }

    @Override
    public void deleteCustomer(final Customer customer) {
        logger.info("SERVICE: START - delete customer");
        customerDao.createCustomer(customer);
        logger.info("SERVICE: END - delete customer");
    }

}
