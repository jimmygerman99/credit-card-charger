package com.jimmygerman.creditcardcharger.controller;

import com.jimmygerman.creditcardcharger.model.Transaction;
import com.jimmygerman.creditcardcharger.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionRepository transactionRepository;
    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @GetMapping
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }
    //RequestBody, literally requests the JSON Body and converts it into a Java Object
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return transactionRepository.save(transaction);
    }

}
