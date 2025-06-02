package com.example.transactionservice.dto;

import lombok.Data;

@Data
public class PharmacyResponseDto {
    private String pharmacyId;
    private String pharmacyName;
    private String pharmacyGstNo;
    private String pharmacyLicenseNo;
}
