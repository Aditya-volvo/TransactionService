package com.example.transactionservice.controller;

import com.example.transactionservice.dto.TransactionRequest;
import com.example.transactionservice.dto.TransactionResponse;
import com.example.transactionservice.model.Transaction;
import com.example.transactionservice.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponse> generateTransaction(@Valid @RequestBody TransactionRequest transactionRequest){
       return transactionService.generateTransaction(transactionRequest);
    }

    @GetMapping
    public List<TransactionResponse> getListOfTransaction(){
        return transactionService.getListOfTransaction();
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionResponse> getTransactionById(@PathVariable long transactionId){
        return transactionService.getTransactionById(transactionId);
    }

    

    @PutMapping("/{transactionId}")
    public ResponseEntity<TransactionResponse> updateTransactionById(@PathVariable long transactionId, @Valid @RequestBody TransactionRequest transactionRequest){
        return transactionService.updateTransactionById(transactionId,transactionRequest);
    }

    @DeleteMapping("/{transactionId}")
    public String deleteTransactionById(@PathVariable Long transactionId){
        return transactionService.deleteTransactionById(transactionId);
    }
}
