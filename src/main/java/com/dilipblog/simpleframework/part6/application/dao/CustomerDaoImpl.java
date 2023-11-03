package com.dilipblog.simpleframework.part6.application.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dilipblog.simpleframework.part6.application.model.Customer;
import com.dilipblog.simpleframework.part6.framework.annotation.Component;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

    @Override
    public void createCustomer(final Customer customer) {
        logger.info("DAO: START: create customer");

        logger.info("DAO: END: create customer");
    }

    @Override
    public void deleteCustomer(final Customer customer) {
        logger.info("DAO: START: delete customer");

        logger.info("DAO: END: delete customer");
    }
}
