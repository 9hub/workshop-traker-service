package com.hub.workshoptrackerserver.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "services")
public class Services implements Serializable {
    
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Boolean stateService;

    @Column(length = 20)
    private String dateInit;

    @Column(length = 20)
    private String dateEnd;

    @Column(length = 2000)
    private String descriptionService;

    @Column(length = 200)
    private String model;

    @ManyToOne
    private Customer customer;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private static final long serialVersionUID = 1L;
}
