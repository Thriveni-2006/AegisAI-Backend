package com.aegisai.controller;

import com.aegisai.dto.EmailScanRequest;
import com.aegisai.dto.EmailScanResponse;
import com.aegisai.service.EmailScanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailScanController {

    private final EmailScanService emailScanService;

    @PostMapping("/scan")
    public EmailScanResponse scanEmail(@RequestBody EmailScanRequest request) {
        return emailScanService.scanEmail(request);
    }
}