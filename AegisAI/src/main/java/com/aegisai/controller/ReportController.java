package com.aegisai.controller;

import com.aegisai.dto.ReportResponse;
import com.aegisai.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/summary")
    public ReportResponse getSummaryReport() {
        return reportService.getSummaryReport();
    }
}