package com.aegisai.service;

import com.aegisai.dto.DashboardResponse;
import com.aegisai.repository.IncidentRepository;
import com.aegisai.repository.ThreatRepository;
import com.aegisai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ThreatRepository threatRepository;

    @Autowired
    private IncidentRepository incidentRepository;

    public DashboardResponse getDashboardData() {

        long users = userRepository.count();
        long threats = threatRepository.count();
        long incidents = incidentRepository.count();

        return new DashboardResponse(users, threats, incidents);
    }
}