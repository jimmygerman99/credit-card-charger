package com.jimmygerman.creditcardcharger.repository;

import com.jimmygerman.creditcardcharger.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCategory(String category);
}


