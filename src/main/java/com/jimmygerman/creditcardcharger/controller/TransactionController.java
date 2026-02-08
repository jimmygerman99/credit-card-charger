package com.jimmygerman.creditcardcharger.controller;

import com.jimmygerman.creditcardcharger.model.Transaction;
import com.jimmygerman.creditcardcharger.repository.TransactionRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
    private final TransactionRepository transactionRepository;
    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @GetMapping
    public List<Transaction> getAllTransactions(){
        logger.info("Fetching all transactions");
        return transactionRepository.findAll();
    }
    @GetMapping("/category/{category}")
    public List<Transaction> getListByCategory(@PathVariable String category){
        return transactionRepository.findByCategory(category);
    }
    //RequestBody, literally requests the JSON Body and converts it into a Java Object
    @PostMapping
    public Transaction createTransaction(@Valid @RequestBody Transaction transaction){
        logger.info("Creating transaction for cardholder: {}, amount: {}", transaction.getCardHolder(), transaction.getAmount());
        return transactionRepository.save(transaction);
    }
    //DeleteById
    @DeleteMapping("/{id}")
    public void deleteTransactionById(@PathVariable Long id){
        logger.info("Deleting transaction with id: {}", id);
        transactionRepository.deleteById(id);
    }

    @DeleteMapping()
    public void clearAllTransactions(){
        logger.warn("Clearing all transactions");
        transactionRepository.deleteAll();
    }

}


