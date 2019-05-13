package com.hub.workshoptrackerserver.controller;

import com.hub.workshoptrackerserver.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerController.RequetsCustomer newCustomer) {
        return customerService.registerCustomerService(newCustomer);

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
