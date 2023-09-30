package com.dilipblog.simpleframework.part1.application.service;

import com.dilipblog.simpleframework.part1.application.dao.CustomerDao;
import com.dilipblog.simpleframework.part1.application.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerDao customerDao;

    public CustomerServiceImpl(final CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void createCustomer(final Customer customer) {
        try {
            beginTransaction();

            logger.info("SERVICE:   START - create customer");
            customerDao.createCustomer(customer);
            logger.info("SERVICE:   END - create customer");

            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            throw e;
        }
    }

    @Override
    public void deleteCustomer(final Customer customer) {
        try {
            beginTransaction();

            logger.info("SERVICE: START - delete customer");
            customerDao.createCustomer(customer);
            logger.info("SERVICE: END - delete customer");

            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            throw e;
        }
    }

    private void beginTransaction() {
        logger.debug("===========BEGIN TRANSACTION===========");
    }

    private void commitTransaction() {
        logger.debug("===========COMMIT TRANSACTION===========");
    }

    private void rollbackTransaction() {
        logger.error("===========ROLLBACK TRANSACTION===========");
    }
}
