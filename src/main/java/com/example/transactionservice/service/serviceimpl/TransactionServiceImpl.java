package com.example.transactionservice.service.serviceimpl;

import com.example.transactionservice.dto.TransactionRequest;
import com.example.transactionservice.dto.TransactionResponse;
import com.example.transactionservice.mapper.GlobalMapper;
import com.example.transactionservice.model.Transaction;
import com.example.transactionservice.repository.TransactionRepository;
import com.example.transactionservice.respone.GlobalResponseEntity;
import com.example.transactionservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final GlobalMapper globalMapper;
    private final GlobalResponseEntity globalResponseEntity;


    @Override
    public ResponseEntity<TransactionResponse> generateTransaction(TransactionRequest transactionRequest) {
        Transaction transaction = globalMapper.mapRequestToEntity(transactionRequest);
        Transaction saved = transactionRepository.save(transaction);
        return globalResponseEntity.mapEntityToRsponseDto(saved);
    }

    @Override
    public List<TransactionResponse> getListOfTransaction() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map(globalMapper::mapRepositoryToResponse).toList();
    }
}
