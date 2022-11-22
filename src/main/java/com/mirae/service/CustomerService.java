package com.mirae.service;

import com.mirae.entity.CustomerEntity;
import com.mirae.model.Customer;
import com.mirae.repository.CustomerRepository;
import com.mirae.util.Common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    Common common;

    public Customer findCustomerById(int customerId) {
        log.info("============ find Customer by Id : {}", customerId);
        CustomerEntity cst = customerRepository.findById(customerId).get();

        return common.mappingCustomer(cst);
    }
}
