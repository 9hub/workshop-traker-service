package com.hub.workshoptrackerserver.controller;

import com.hub.workshoptrackerserver.model.Work;
import com.hub.workshoptrackerserver.model.Work;
import com.hub.workshoptrackerserver.service.WorkService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<?> registerWork(@RequestBody WorkController.RequestWork newWork) {
        return workService.registerWorkService(newWork);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseEntity<?> updateWork(@PathVariable("id") Long id, @RequestBody Work updWork){
        return workService.updateWorkService(id, updWork);
    }

    public static class RequestWork {
        private Long Id;
        private Boolean stateWork;
        private String dateInit;
        private String dateEnd;
        private String descriptionWork;
        private String model;
        private Long idCustomer;

        public Long getId() {
            return Id;
        }

        public void setId(Long id) {
            Id = id;
        }

        public Boolean getStateWork() {
            return stateWork;
        }

        public void setStateWork(Boolean stateWork) {
            this.stateWork = stateWork;
        }

        public String getDateInit() {
            return dateInit;
        }

        public void setDateInit(String dateInit) {
            this.dateInit = dateInit;
        }

        public String getDateEnd() {
            return dateEnd;
        }

        public void setDateEnd(String dateEnd) {
            this.dateEnd = dateEnd;
        }

        public String getDescriptionWork() {
            return descriptionWork;
        }

        public void setDescriptionWork(String descriptionWork) {
            this.descriptionWork = descriptionWork;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Long getIdCustomer() {
            return idCustomer;
        }

        public void setIdCustomer(Long idCustomer) {
            this.idCustomer = idCustomer;
        }
    }

}
