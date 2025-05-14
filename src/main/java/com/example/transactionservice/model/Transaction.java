package com.example.transactionservice.model;

import com.example.transactionservice.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private TransactionType transcationType;

    @Column(name = "transaction_date")
    private LocalDateTime dateTime;

    @Column(name = "tran_quantity")
    private int quantity;
//FK linking
    private Long medicineId;
    private Long pharmacyId;
    private Long patientId;

}
