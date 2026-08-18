package com.java.talent.batch12.atm.service;

import com.java.talent.batch12.atm.model.Account;
import com.java.talent.batch12.atm.model.Transaction;
import com.java.talent.batch12.atm.model.enumType.TransactionType;
import com.java.talent.batch12.atm.repository.AccountRepository;
import com.java.talent.batch12.atm.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServices {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final AccountServices accountServices;

    public Transaction withdraw(String userName, int amount){
        if(amount <= 0)
        {
            System.out.println("amount cannot be zero");
        }

        Account currentAccount = accountRepository.findByUsername(userName);
        double currentBalance = currentAccount.getBalance();
        if(amount > currentBalance)
        {
            System.out.println("insufficient amount");
        }
        double newBalance = currentBalance - amount;

        currentAccount.setBalance(accountServices.updateBalance(userName,newBalance));
        accountRepository.save(currentAccount);
        Transaction transaction = new Transaction();
        transaction.setAccountId(currentAccount.getAccountId());
        transaction.setTransactionType(TransactionType.WITHDRAW);
        transaction.setAmount(amount);

        return transactionRepository.save(transaction);

    }
    public Transaction deposit(String userName, int amount){
        if(amount <= 0)
        {
            System.out.println("amount cannot be zero");
        }

        Account currentAccount = accountRepository.findByUsername(userName);
        double currentBalance = currentAccount.getBalance();
        double newBalance = currentBalance + amount;
        currentAccount.setBalance(accountServices.updateBalance(userName,newBalance));
        accountRepository.save(currentAccount);

        Transaction transaction = new Transaction();
        transaction.setAccountId(currentAccount.getAccountId());
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setAmount(amount);

        return transactionRepository.save(transaction);

    }

    public List<Transaction> getTransactionsByAccountId(int userId) {
        if (userId == 0) {
            System.out.println("User ID cannot be empty");
            return new ArrayList<>();
        }

        List<Transaction> transactions = transactionRepository.findByAccountId(userId);
        if (transactions == null || transactions.isEmpty()) {
            System.out.println("No transactions found for account: " + userId);
            return new ArrayList<>();
        }
        return transactions;
    }

    public List<Transaction> getTransactionByTransactionId(Integer transactionId) {
        if (transactionId == null) {
            System.out.println("Transaction ID cannot be null");
            return null;
        }
        
        return transactionRepository.findByTransactionId(transactionId);
    }
}