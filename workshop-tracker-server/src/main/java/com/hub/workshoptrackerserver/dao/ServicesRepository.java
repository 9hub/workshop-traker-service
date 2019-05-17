package com.hub.workshoptrackerserver.dao;

import com.hub.workshoptrackerserver.model.Services;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServicesRepository extends CrudRepository<Services, Long> {
    @Query(value = "select * from Services", nativeQuery = true)
    public List<Services> findAll();
}
