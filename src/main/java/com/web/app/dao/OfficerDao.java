package com.web.app.dao;

import com.web.app.entities.Officer;

import java.util.List;
import java.util.Optional;

public interface OfficerDao {
    Officer save(Officer officer);
    Optional<Officer> findById(Integer id);
    List<Officer> findAll();
    void delete(Officer officer);
    boolean existById(Integer id);
    long count();
}
