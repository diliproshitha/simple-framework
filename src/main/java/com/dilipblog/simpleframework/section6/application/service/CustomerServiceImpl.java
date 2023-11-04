package com.dilipblog.simpleframework.section6.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dilipblog.simpleframework.section6.application.dao.CustomerDao;
import com.dilipblog.simpleframework.section6.application.model.Customer;
import com.dilipblog.simpleframework.section6.framework.annotation.Autowired;
import com.dilipblog.simpleframework.section6.framework.annotation.Component;
import com.dilipblog.simpleframework.section6.framework.annotation.Transactional;

@Component
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(final CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public void createCustomer(final Customer customer) {
        logger.info("SERVICE:   START - create customer");
        customerDao.createCustomer(customer);
        logger.info("SERVICE:   END - create customer");
    }

    @Override
    @Transactional
    public void deleteCustomer(final Customer customer) {
        logger.info("SERVICE: START - delete customer");
        customerDao.createCustomer(customer);
        logger.info("SERVICE: END - delete customer");
    }

}
