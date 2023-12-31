package com.dilipblog.simpleframework.section1.application.dao;

import com.dilipblog.simpleframework.section1.application.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerDaoImpl implements CustomerDao {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

    @Override
    public void createCustomer(final Customer customer) {
        logger.info("START: create customer");

        logger.info("END: create customer");
    }

    @Override
    public void deleteCustomer(final Customer customer) {
        logger.info("START: delete customer");

        logger.info("END: delete customer");
    }
}
