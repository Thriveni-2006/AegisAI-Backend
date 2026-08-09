package com.aegisai.controller;

import com.aegisai.entity.Incident;
import com.aegisai.service.IncidentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @PostMapping
    public Incident addIncident(@Valid @RequestBody Incident incident) {
        return incidentService.addIncident(incident);
    }

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    @GetMapping("/{id}")
    public Incident getIncidentById(@PathVariable Long id) {
        return incidentService.getIncidentById(id);
    }

    @PutMapping("/{id}")
    public Incident updateIncident(@PathVariable Long id,
                                   @RequestBody Incident incident) {
        return incidentService.updateIncident(id, incident);
    }

    @DeleteMapping("/{id}")
    public String deleteIncident(@PathVariable Long id) {
        return incidentService.deleteIncident(id);
    }

    @GetMapping("/status/{status}")
    public List<Incident> getIncidentsByStatus(@PathVariable String status) {
        return incidentService.getIncidentsByStatus(status);
    }

    @GetMapping("/priority/{priority}")
    public List<Incident> getIncidentsByPriority(@PathVariable String priority) {
        return incidentService.getIncidentsByPriority(priority);
    }

    @GetMapping("/page")
    public Page<Incident> getIncidentsPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return incidentService.getIncidentsPage(page, size);
    }
}