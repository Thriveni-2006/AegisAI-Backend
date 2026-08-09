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

        long totalUsers = userRepository.count();
        long totalThreats = threatRepository.count();
        long totalIncidents = incidentRepository.count();

        long openIncidents = incidentRepository.countByStatus("OPEN");
        long resolvedIncidents = incidentRepository.countByStatus("RESOLVED");

        DashboardResponse response = new DashboardResponse();

        response.setTotalThreats(totalThreats);
        response.setTotalIncidents(totalIncidents);
        response.setOpenIncidents(openIncidents);
        response.setResolvedIncidents(resolvedIncidents);

        return response;
    }
}