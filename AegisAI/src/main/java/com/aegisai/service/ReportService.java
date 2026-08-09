package com.aegisai.service;

import com.aegisai.dto.ReportResponse;
import com.aegisai.repository.IncidentRepository;
import com.aegisai.repository.NotificationRepository;
import com.aegisai.repository.ThreatRepository;
import com.aegisai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ThreatRepository threatRepository;

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    public ReportResponse getSummaryReport() {

        ReportResponse response = new ReportResponse();

        response.setTotalUsers(userRepository.count());
        response.setTotalThreats(threatRepository.count());
        response.setTotalIncidents(incidentRepository.count());
        response.setTotalNotifications(notificationRepository.count());

        return response;
    }
}