package com.aegisai.service;

import com.aegisai.dto.UrlScanRequest;
import com.aegisai.dto.UrlScanResponse;
import org.springframework.stereotype.Service;

@Service
public class UrlScanService {

    public UrlScanResponse scanUrl(UrlScanRequest request) {

        String url = request.getUrl().toLowerCase();

        int riskScore = 0;

        if (url.contains("bit.ly"))
            riskScore += 30;

        if (url.contains("@"))
            riskScore += 20;

        if (url.contains("login"))
            riskScore += 15;

        if (url.contains("verify"))
            riskScore += 20;

        if (url.contains("free"))
            riskScore += 15;

        String status;
        String message;

        if (riskScore >= 60) {
            status = "MALICIOUS";
            message = "Malicious URL Detected";
        } else if (riskScore >= 30) {
            status = "SUSPICIOUS";
            message = "Suspicious URL";
        } else {
            status = "SAFE";
            message = "URL Looks Safe";
        }

        return new UrlScanResponse(status, riskScore, message);
    }
}