package com.aegisai.repository;

import com.aegisai.entity.Threat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThreatRepository extends JpaRepository<Threat, Long> {

    List<Threat> findBySeverity(String severity);

    List<Threat> findByStatus(String status);

}