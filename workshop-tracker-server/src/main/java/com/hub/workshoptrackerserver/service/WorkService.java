package com.hub.workshoptrackerserver.service;

import com.hub.workshoptrackerserver.controller.WorkController;
import com.hub.workshoptrackerserver.dao.CustomerRepository;
import com.hub.workshoptrackerserver.dao.WorkRepository;
import com.hub.workshoptrackerserver.model.Work;
import com.hub.workshoptrackerserver.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
            Work work = new Work();
            work.setId(newWork.getId());
            work.setStateWork(newWork.getStateWork());
            work.setDateInit(newWork.getDateInit());
            work.setDateEnd(newWork.getDateEnd());
            work.setDescriptionWork(newWork.getDescriptionWork());
            work.setModel(newWork.getModel());
            workRepository.save(work);
            return new ResponseEntity<>(new ResponseMessage("Work registered successfully!"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ResponseMessage("No exist Customer not!"), HttpStatus.BAD_REQUEST);
        }
    }
}
