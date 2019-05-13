package com.hub.workshoptrackerserver.service;

import com.hub.workshoptrackerserver.controller.CustomerController;
import com.hub.workshoptrackerserver.dao.CustomerRepository;
import com.hub.workshoptrackerserver.model.Customer;
import com.hub.workshoptrackerserver.response.ResponseMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<?> registerCustomerService(CustomerController.RequetsCustomer newCustomer) {
        Customer customer = new Customer();
        customer.setId(newCustomer.getId());
        customer.setName(newCustomer.getName());
        customer.setLastName(newCustomer.getLastName());
        customer.setEmail(newCustomer.getEmail());
        customer.setMobile(newCustomer.getMobile());
        customer.setPhone(newCustomer.getPhone());
        customerRepository.save(customer);
        return new ResponseEntity<>(new ResponseMessage("Customer registered successfully!"), HttpStatus.OK);
    }

    public List<Customer> getListCustumersService() {
        return customerRepository.findAll();
    }
}
