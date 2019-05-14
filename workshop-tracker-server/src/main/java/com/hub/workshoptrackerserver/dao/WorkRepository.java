package com.hub.workshoptrackerserver.dao;

import com.hub.workshoptrackerserver.model.Work;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkRepository extends CrudRepository<Work, Long> {
    @Query(value = "select * from works", nativeQuery = true)
    public List<Work> findAll();
}
