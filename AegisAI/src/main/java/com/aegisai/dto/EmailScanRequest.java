package com.aegisai.dto;

import lombok.Data;

@Data
public class EmailScanRequest {

    private String sender;

    private String subject;

    private String body;
}