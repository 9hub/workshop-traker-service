package com.hub.workshoptrackerserver.service;

import java.util.Optional;
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
    public ResponseEntity<?> updateCustomerService(Long id, Customer updCustomer){
        if(customerRepository.existsById(id)){            
            Optional<Customer> customerOptional = customerRepository.findById(id);
            Customer customerDb = customerOptional.get();
            customerDb.setId(updCustomer.getId());
            customerDb.setName(updCustomer.getName());
            customerDb.setLastName(updCustomer.getLastName());
            customerDb.setEmail(updCustomer.getEmail());
            customerDb.setMobile(updCustomer.getMobile());
            customerDb.setPhone(updCustomer.getPhone());
            customerRepository.save(customerDb);
            return new ResponseEntity<>(new ResponseMessage("Customer update successfully!"), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ResponseMessage("Fail Customer update!"), HttpStatus.BAD_REQUEST);
        }
    }

	public Customer getCustomerService(Long id) {
        Customer customer = new Customer();
        if(customerRepository.existsById(id)){
            Optional<Customer> customerOptional = customerRepository.findById(id);
            customer = customerOptional.get();
        }
        return customer;

	}
}
