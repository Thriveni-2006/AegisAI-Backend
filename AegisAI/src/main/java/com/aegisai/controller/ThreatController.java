package com.aegisai.controller;

import com.aegisai.entity.Threat;
import com.aegisai.service.ThreatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/threats")
public class ThreatController {

    @Autowired
    private ThreatService threatService;

    // Add Threat
    @PostMapping
    public Threat addThreat(@Valid @RequestBody Threat threat) {
        return threatService.addThreat(threat);
    }

    // Get All Threats
    @GetMapping
    public List<Threat> getAllThreats() {
        return threatService.getAllThreats();
    }

    // Get Threat By ID
    @GetMapping("/{id}")
    public Threat getThreatById(@PathVariable Long id) {
        return threatService.getThreatById(id);
    }

    // Update Threat
    @PutMapping("/{id}")
    public Threat updateThreat(@PathVariable Long id,
                               @RequestBody Threat threat) {
        return threatService.updateThreat(id, threat);
    }

    // Delete Threat
    @DeleteMapping("/{id}")
    public String deleteThreat(@PathVariable Long id) {
        return threatService.deleteThreat(id);
    }

    // Search by Severity
    @GetMapping("/severity/{severity}")
    public List<Threat> getThreatsBySeverity(@PathVariable String severity) {
        return threatService.getThreatsBySeverity(severity);
    }

    // Search by Status
    @GetMapping("/status/{status}")
    public List<Threat> getThreatsByStatus(@PathVariable String status) {
        return threatService.getThreatsByStatus(status);
    }

    // Pagination
    @GetMapping("/page")
    public Page<Threat> getThreatsPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return threatService.getThreatsPage(page, size);
    }
}