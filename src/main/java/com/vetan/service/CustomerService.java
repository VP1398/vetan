package com.vetan.service;

import com.vetan.dto.CustomerData;

import java.util.List;

public interface CustomerService {

    CustomerData saveCustomer(CustomerData customer);
    boolean deleteCustomer(final Long customerId);
    List<CustomerData> getAllCustomers();
    CustomerData getCustomerById(final Long customerId);
}
