package com.hub.workshoptrackerserver.service;

import com.hub.workshoptrackerserver.controller.WorkController;
import com.hub.workshoptrackerserver.dao.CustomerRepository;
import com.hub.workshoptrackerserver.dao.WorkRepository;
import com.hub.workshoptrackerserver.model.Customer;
import com.hub.workshoptrackerserver.model.Work;
import com.hub.workshoptrackerserver.response.ResponseMessage;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkService {
    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Work> getListWorksService() {
        return workRepository.findAll();
    }

    public ResponseEntity<?> registerWorkService(WorkController.RequestWork newWork) {
        if(customerRepository.existsById(newWork.getIdCustomer())) {
            Optional<Customer> customerOptional = customerRepository.findById(newWork.getIdCustomer());
            Customer customerDb = customerOptional.get();
            Work work = new Work();
            work.setId(newWork.getId());
            work.setStateWork(newWork.getStateWork());
            work.setDateInit(newWork.getDateInit());
            work.setDateEnd(newWork.getDateEnd());
            work.setDescriptionWork(newWork.getDescriptionWork());
            work.setModel(newWork.getModel());
            work.setCustomer(customerDb);
            workRepository.save(work);
            return new ResponseEntity<>(new ResponseMessage("Work registered successfully!"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ResponseMessage("No exist Work not!"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> updateWorkService(Long id, Work updWork) {
        if(workRepository.existsById(id)){
            Optional<Work> workOptional = workRepository.findById(updWork.getId());
            Work workDb = workOptional.get();
            workDb.setId(updWork.getId());
            workDb.setStateWork(updWork.getStateWork());
            workDb.setDateInit(updWork.getDateInit());
            workDb.setDateEnd(updWork.getDateEnd());
            workDb.setDescriptionWork(updWork.getDescriptionWork());
            workDb.setModel(updWork.getModel());
            workDb.setCustomer(updWork.getCustomer());
            workRepository.save(workDb);
            return new ResponseEntity<>(new ResponseMessage("Work update successfully!"), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ResponseMessage("Fail Work update!"), HttpStatus.BAD_REQUEST);
        }
    }
}
