package com.example.transactionservice.dto;

import com.example.transactionservice.enums.TransactionType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {
    private Long transactionId;
    private TransactionType transactionType;
    private LocalDateTime dateTime;
    private Long quantity;
    private Long medicineId;
    private Long pharmacyId;
    private Long patientId;

}
