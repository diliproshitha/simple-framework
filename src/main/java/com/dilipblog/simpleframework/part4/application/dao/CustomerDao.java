package com.dilipblog.simpleframework.part4.application.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dilipblog.simpleframework.part4.application.model.Customer;

public class CustomerDao {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDao.class);

    public void createCustomer(final Customer customer) {
        logger.info("DAO: START: create customer");

        logger.info("DAO: END: create customer");
    }

    public void deleteCustomer(final Customer customer) {
        logger.info("DAO: START: delete customer");

        logger.info("DAO: END: delete customer");
    }
}
