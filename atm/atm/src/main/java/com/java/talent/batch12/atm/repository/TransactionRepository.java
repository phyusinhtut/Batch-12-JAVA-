package com.java.talent.batch12.atm.repository;

import com.java.talent.batch12.atm.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> // <Entity className, Primary Key Data type>
{
    List<Transaction> findByAccountId(int accountId);
    List<Transaction> findByTransactionId(int transactionId);
}