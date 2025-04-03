package com.web.app.dao;

import com.web.app.entities.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {
}
