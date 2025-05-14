package com.example.transactionservice.dto;

import com.example.transactionservice.enums.TransactionType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
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
public class TransactionRequest {
    @NotBlank
    private TransactionType transactionType;
    @NotBlank
    private LocalDateTime dateTime;
    @NotBlank
    @Positive
    private Long quantity;
    @NotBlank
    private Long medicineId;
    @NotBlank
    private Long pharmacyId;
    @NotBlank
    private Long patientId;
}
