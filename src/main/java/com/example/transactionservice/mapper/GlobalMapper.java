package com.example.transactionservice.mapper;

import com.example.transactionservice.dto.TransactionRequest;
import com.example.transactionservice.dto.TransactionResponse;
import com.example.transactionservice.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class GlobalMapper {

    public Transaction mapRequestToEntity(TransactionRequest transactionRequest){
        return Transaction.builder()
                .transactionType(transactionRequest.getTransactionType())
                .dateTime(transactionRequest.getDateTime())
                .quantity(transactionRequest.getQuantity())
                .medicineId(transactionRequest.getMedicineId())
                .pharmacyId(transactionRequest.getPharmacyId())
                .patientId(transactionRequest.getPatientId())
                .build();
    }

    public TransactionResponse mapRepositoryToResponse(Transaction transaction) {
        return TransactionResponse.builder()
                .transactionId(transaction.getTransactionId())
                .transactionType(transaction.getTransactionType())
                .dateTime(transaction.getDateTime())
                .quantity(transaction.getQuantity())
                .quantity(transaction.getQuantity())
                .pharmacyId(transaction.getPharmacyId())
                .medicineId(transaction.getMedicineId())
                .patientId(transaction.getPatientId())
                .build();
    }
}
