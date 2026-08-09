package com.aegisai.service;

import com.aegisai.entity.Incident;
import com.aegisai.exception.ResourceNotFoundException;
import com.aegisai.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public Incident addIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Page<Incident> getIncidentsPage(int page, int size) {
        return incidentRepository.findAll(PageRequest.of(page, size));
    }

    public Incident getIncidentById(Long id) {
        return incidentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Incident not found with ID: " + id));
    }

    public Incident updateIncident(Long id, Incident incident) {

        Incident existingIncident = incidentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Incident not found with ID: " + id));

        existingIncident.setTitle(incident.getTitle());
        existingIncident.setDescription(incident.getDescription());
        existingIncident.setStatus(incident.getStatus());
        existingIncident.setPriority(incident.getPriority());

        return incidentRepository.save(existingIncident);
    }

    public String deleteIncident(Long id) {

        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Incident not found with ID: " + id));

        incidentRepository.delete(incident);

        return "Incident deleted successfully!";
    }

    public List<Incident> getIncidentsByStatus(String status) {
        return incidentRepository.findByStatus(status);
    }

    public List<Incident> getIncidentsByPriority(String priority) {
        return incidentRepository.findByPriority(priority);
    }
}