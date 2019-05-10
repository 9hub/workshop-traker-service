package com.hub.workshoptrackerserver.service;

import com.hub.workshoptrackerserver.controller.CustomerController;
import com.hub.workshoptrackerserver.dao.CustomerRepository;
import com.hub.workshoptrackerserver.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void registerCustomerService(CustomerController.RequetsCustomer newCustomer) {
        Customer customer = new Customer();
        customer.setId(newCustomer.getId());
        customer.setName(newCustomer.getName());
        customer.setLastName(newCustomer.getLastName());
        customer.setEmail(newCustomer.getEmail());
        customer.setCellPhoneNumber(newCustomer.getCellPhoneNumber());
        customer.setPhoneNumber(newCustomer.getPhoneNumber());
        customerRepository.save(customer);
    }
}
