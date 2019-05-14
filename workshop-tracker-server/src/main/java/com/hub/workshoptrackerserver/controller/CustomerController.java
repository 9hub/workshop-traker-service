package com.hub.workshoptrackerserver.controller;

import com.hub.workshoptrackerserver.model.Customer;
import com.hub.workshoptrackerserver.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
@Api(value = "customers", description = "Customer description")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustumers() {
        System.out.println("List Customers");
        return customerService.getListCustumersService();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerController.RequetsCustomer newCustomer) {
        return customerService.registerCustomerService(newCustomer);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer updCustomer){
        return customerService.updateCustomerService(id, updCustomer);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customer/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return customerService.getCustomerService(id);
    }


    public static class RequetsCustomer {

        private Long Id;
        private String name;
        private String lastName;
        private String email;
        private Integer mobile;
        private Integer phone;

        public Long getId() {
            return Id;
        }

        public void setId(Long id) {
            Id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getMobile() {
            return mobile;
        }

        public void setMobile(Integer mobile) {
            this.mobile = mobile;
        }

        public Integer getPhone() {
            return phone;
        }

        public void setPhone(Integer phone) {
            this.phone = phone;
        }
    }
}
