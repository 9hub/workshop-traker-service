package com.hub.workshoptrackerserver.service;

import com.hub.workshoptrackerserver.controller.ServicesController;
import com.hub.workshoptrackerserver.dao.CustomerRepository;
import com.hub.workshoptrackerserver.dao.ServicesRepository;
import com.hub.workshoptrackerserver.model.Customer;
import com.hub.workshoptrackerserver.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hub.workshoptrackerserver.model.Services;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Services> getListServicesService() {
        return servicesRepository.findAll();
    }

    public ResponseEntity<?> registerServicesService(ServicesController.RequestServices newService) {
        if(customerRepository.existsById(newService.getIdCustomer())) {
            Optional<Customer> customerOptional = customerRepository.findById(newService.getIdCustomer());
            Customer customerDb = customerOptional.get();
            Services services = new Services();
            services.setId(newService.getId());
            services.setStateService(newService.getStateService());
            services.setDateInit(newService.getDateInit());
            services.setDateEnd(newService.getDateEnd());
            services.setDescriptionService(newService.getDescriptionService());
            services.setModel(newService.getModel());
            services.setCustomer(customerDb);
            servicesRepository.save(services);
            return new ResponseEntity<>(new ResponseMessage("Services registered successfully!"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ResponseMessage("No exist Services not!"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> updateServiceService(Long id, Services updServices) {
        if(servicesRepository.existsById(id)){
            Optional<Services> ServiceOptional = servicesRepository.findById(updServices.getId());
            Services servicesDb = ServiceOptional.get();
            servicesDb.setId(updServices.getId());
            servicesDb.setStateService(updServices.getStateService());
            servicesDb.setDateInit(updServices.getDateInit());
            servicesDb.setDateEnd(updServices.getDateEnd());
            servicesDb.setDescriptionService(updServices.getDescriptionService());
            servicesDb.setModel(updServices.getModel());
            servicesDb.setCustomer(updServices.getCustomer());
            servicesRepository.save(servicesDb);
            return new ResponseEntity<>(new ResponseMessage("Services update successfully!"), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ResponseMessage("Fail Services update!"), HttpStatus.BAD_REQUEST);
        }
    }
}