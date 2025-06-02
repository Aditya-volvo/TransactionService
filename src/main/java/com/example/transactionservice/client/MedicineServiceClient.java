package com.example.transactionservice.client;

import com.example.transactionservice.dto.MedicineDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "medicine-service", url = "${medicine.service.url}")
public interface MedicineServiceClient {
    // Define methods to interact with the medicine service here
     @GetMapping("/api/medicine/{id}")
     MedicineDto getMedicineById(@PathVariable("id") Long id);

}
