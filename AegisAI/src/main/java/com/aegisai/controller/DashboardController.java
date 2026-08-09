package com.aegisai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @GetMapping("/stats")
    public Map<String, Object> getStats() {

        Map<String, Object> stats = new HashMap<>();

        stats.put("totalScans", 128);
        stats.put("threatsBlocked", 14);
        stats.put("reports", 9);
        stats.put("activeAlerts", 3);
        stats.put("securityScore", 91);

        return stats;
    }
}