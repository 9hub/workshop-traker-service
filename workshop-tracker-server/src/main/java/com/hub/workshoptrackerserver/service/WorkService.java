package com.hub.workshoptrackerserver.service;

import com.hub.workshoptrackerserver.dao.WorkRepository;
import com.hub.workshoptrackerserver.model.Customer;
import com.hub.workshoptrackerserver.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkService {
    @Autowired
    private WorkRepository workRepository;
    public List<Work> getListWorksService() {
        return workRepository.findAll();
    }
}
