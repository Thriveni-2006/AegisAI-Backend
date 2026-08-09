package com.aegisai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailScanResponse {

    private String status;
    private int riskScore;
    private String message;
}