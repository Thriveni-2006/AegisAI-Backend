package com.aegisai.service;

import com.aegisai.dto.EmailScanRequest;
import com.aegisai.dto.EmailScanResponse;
import org.springframework.stereotype.Service;

@Service
public class EmailScanService {

    public EmailScanResponse scanEmail(EmailScanRequest request) {

        int riskScore = 0;
        String content = (request.getSubject() + " " + request.getBody()).toLowerCase();

        if (content.contains("urgent")) riskScore += 20;
        if (content.contains("click here")) riskScore += 20;
        if (content.contains("verify")) riskScore += 15;
        if (content.contains("password")) riskScore += 20;
        if (content.contains("bank")) riskScore += 15;
        if (content.contains("account")) riskScore += 10;

        String status;
        String message;

        if (riskScore >= 60) {
            status = "PHISHING";
            message = "High-risk phishing email detected.";
        } else if (riskScore >= 30) {
            status = "SUSPICIOUS";
            message = "Email looks suspicious.";
        } else {
            status = "SAFE";
            message = "No phishing indicators found.";
        }

        return new EmailScanResponse(status, riskScore, message);
    }
}