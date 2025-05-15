package com.example.transactionservice.service.serviceimpl;

import com.example.transactionservice.dto.TransactionRequest;
import com.example.transactionservice.dto.TransactionResponse;
import com.example.transactionservice.exception.ResourceNotFoundException;
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

    @Override
    public ResponseEntity<TransactionResponse> getTransactionById(long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(()->new ResourceNotFoundException("The Transaction with Id :"+transactionId+"not found"));
        return globalResponseEntity.mapEntityToRsponseDto(transaction);
    }

    @Override
    public ResponseEntity<TransactionResponse> updateTransactionById(long transactionId,TransactionRequest transactionRequest) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(()->new ResourceNotFoundException("The Transaction with Id :"+transactionId+"not found"));
        transaction.setTransactionType(transactionRequest.getTransactionType());
        transaction.setQuantity(transactionRequest.getQuantity());
        transaction.setDateTime(transactionRequest.getDateTime());
        transaction.setPharmacyId(transactionRequest.getPharmacyId());
        transaction.setMedicineId(transactionRequest.getMedicineId());
        transaction.setPatientId(transactionRequest.getPatientId());
        Transaction saved = transactionRepository.save(transaction);
        return globalResponseEntity.mapEntityToRsponseDto(saved);
    }

    @Override
    public String deleteTransactionById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(()->new ResourceNotFoundException("The Transaction with Id :"+transactionId+"not found"));
        transactionRepository.delete(transaction);
        return "Transaction with Id :"+transaction.getTransactionId()+"was Deleted";
    }
}
