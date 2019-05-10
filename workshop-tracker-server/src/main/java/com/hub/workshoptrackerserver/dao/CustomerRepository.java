package com.hub.workshoptrackerserver.dao;

import com.hub.workshoptrackerserver.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
