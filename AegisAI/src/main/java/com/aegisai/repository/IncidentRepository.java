package com.aegisai.repository;

import com.aegisai.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {

    List<Incident> findByStatus(String status);

    List<Incident> findByPriority(String priority);

    long countByStatus(String status);
}

