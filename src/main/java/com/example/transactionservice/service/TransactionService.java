package com.example.transactionservice.service;

import com.example.transactionservice.dto.TransactionRequest;
import com.example.transactionservice.dto.TransactionResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionService {
    ResponseEntity<TransactionResponse> generateTransaction(@Valid TransactionRequest transactionRequest);

    List<TransactionResponse> getListOfTransaction();
}
