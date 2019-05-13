package com.hub.workshoptrackerserver.dao;

import com.hub.workshoptrackerserver.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query(value = "select * from customers", nativeQuery = true)
    public List<Customer> findAll();
}
