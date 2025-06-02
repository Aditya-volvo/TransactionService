package com.example.transactionservice.client;

import com.example.transactionservice.dto.PharmacyResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pharmacy-service", url = "${pharmacy.service.url}")
public interface PharmacyServiceClient {

    // Define methods to interact with the pharmacy service here
    // For example, you might have a method to get pharmacy details by ID
    @GetMapping("/api/pharmacies/transaction/{id}")
    PharmacyResponseDto getPharmacyByTransactionId(@PathVariable("id") Long transactionId);
}
