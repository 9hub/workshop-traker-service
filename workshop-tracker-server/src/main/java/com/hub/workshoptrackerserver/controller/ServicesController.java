package com.hub.workshoptrackerserver.controller;


import com.hub.workshoptrackerserver.model.Services;
import com.hub.workshoptrackerserver.service.ServicesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("services")
@Api(value = "service", description = "services request")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Services> listservices() {
        return servicesService.getListServicesService();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registerservice(@RequestBody ServicesController.RequestServices newServices) {
        return servicesService.registerServicesService(newServices);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updateservice(@PathVariable("id") Long id, @RequestBody Services updServices){
        return servicesService.updateServiceService(id, updServices);
    }

    public static class RequestServices {
        private Long Id;
        private Boolean stateService;
        private String dateInit;
        private String dateEnd;
        private String descriptionService;
        private String model;
        private Long idCustomer;

        public Long getId() {
            return Id;
        }

        public void setId(Long id) {
            Id = id;
        }

        public Boolean getStateService() {
            return stateService;
        }

        public void setStateService(Boolean stateService) {
            this.stateService = stateService;
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

        public String getDescriptionService() {
            return descriptionService;
        }

        public void setDescriptionService(String descriptionService) {
            this.descriptionService = descriptionService;
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