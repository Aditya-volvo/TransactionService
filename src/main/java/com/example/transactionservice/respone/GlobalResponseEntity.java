package com.example.transactionservice.respone;

import com.example.transactionservice.dto.TransactionResponse;
import com.example.transactionservice.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GlobalResponseEntity {
    public ResponseEntity<TransactionResponse> mapEntityToRsponseDto(Transaction transaction){
        return ResponseEntity.ok(
                new TransactionResponse(
                        transaction.getTransactionId(),
                        transaction.getTransactionType(),
                        transaction.getDateTime(),
                        transaction.getQuantity(),
                        transaction.getMedicineId(),
                        transaction.getPharmacyId(),
                        transaction.getPatientId()
                ));
    }
}
