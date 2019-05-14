package com.hub.workshoptrackerserver.controller;

import com.hub.workshoptrackerserver.model.Work;
import com.hub.workshoptrackerserver.service.WorkService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("works")
@Api(value = "work", description = "Works request")
public class WorkController {

    @Autowired
    private WorkService workService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Work> listWorks() {
        return workService.getListWorksService();
    }
}
