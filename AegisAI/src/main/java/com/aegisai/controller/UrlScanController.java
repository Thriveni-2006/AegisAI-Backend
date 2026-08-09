package com.aegisai.controller;

import com.aegisai.dto.UrlScanRequest;
import com.aegisai.dto.UrlScanResponse;
import com.aegisai.service.UrlScanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor
public class UrlScanController {

    private final UrlScanService urlScanService;

    @PostMapping("/scan")
    public UrlScanResponse scanUrl(@RequestBody UrlScanRequest request) {
        return urlScanService.scanUrl(request);
    }
}