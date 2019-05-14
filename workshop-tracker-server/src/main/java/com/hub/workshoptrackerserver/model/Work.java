package com.hub.workshoptrackerserver.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "works")
public class Work implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Boolean stateWork;

    @Column(length = 20)
    private String dateInit;

    @Column(length = 20)
    private String dateEnd;

    @Column(length = 2000)
    private String descriptionWork;

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

    public Boolean getStateWork() {
        return stateWork;
    }

    public void setStateWork(Boolean stateWork) {
        this.stateWork = stateWork;
    }

    public String getDateInit() {
        return dateInit;
    }

    public void setDateInit(String dateinit) {
        this.dateInit = dateinit;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}