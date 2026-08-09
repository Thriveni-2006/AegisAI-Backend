package com.aegisai.service;

import com.aegisai.entity.Threat;
import com.aegisai.exception.ResourceNotFoundException;
import com.aegisai.repository.ThreatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreatService {

    @Autowired
    private ThreatRepository threatRepository;

    public Threat addThreat(Threat threat) {
        return threatRepository.save(threat);
    }

    public List<Threat> getAllThreats() {
        return threatRepository.findAll();
    }

    public Page<Threat> getThreatsPage(int page, int size) {
        return threatRepository.findAll(PageRequest.of(page, size));
    }

    public Threat getThreatById(Long id) {
        return threatRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Threat not found with ID: " + id));
    }

    public Threat updateThreat(Long id, Threat threat) {

        Threat existingThreat = threatRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Threat not found with ID: " + id));

        existingThreat.setTitle(threat.getTitle());
        existingThreat.setDescription(threat.getDescription());
        existingThreat.setSeverity(threat.getSeverity());
        existingThreat.setStatus(threat.getStatus());

        return threatRepository.save(existingThreat);
    }

    public String deleteThreat(Long id) {

        Threat threat = threatRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Threat not found with ID: " + id));

        threatRepository.delete(threat);

        return "Threat deleted successfully!";
    }

    public List<Threat> getThreatsBySeverity(String severity) {
        return threatRepository.findBySeverity(severity);
    }

    public List<Threat> getThreatsByStatus(String status) {
        return threatRepository.findByStatus(status);
    }
}