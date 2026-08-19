package com.java.talent.batch12.atm;

import com.java.talent.batch12.atm.model.Transaction;
import com.java.talent.batch12.atm.service.AccountServices;
import com.java.talent.batch12.atm.service.TransactionServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AtmApplicationTests {

    @Autowired
    AccountServices accountService;

    @Autowired
    TransactionServices transactionServices;

    @Test
    void contextLoads() {
    }

    @Test
    void createAccount() {
        System.out.println(accountService.createAccount("John", "John@22", "john@gmail.com","Yangon"));
    }

    @Test
    void loginAccount()
    {
        System.out.println(accountService.loginAccount("John","John@22"));
    }

    @Test
    void deleteAccount()
    {
        System.out.println(accountService.deleteAccount("John", "John@22"));
    }

    @Test
    void getAccountByUserName()
    {
        System.out.println(accountService.getAccountByUserName("John"));
    }

    @Test
    void withdraw()
    {
        System.out.println(transactionServices.withdraw("Emily",500));
    }

    @Test
    void deposit()
    {
        System.out.println(transactionServices.deposit("John",1000));
    }

    @Test
    void getTransactionsByAccountId()
    {
        List<Transaction> transactions = transactionServices.getTransactionsByAccountId(1);
        System.out.println(transactions.toString());
    }

    @Test
    void getTransactionsByTransactionId()
    {
        List<Transaction> transactions = transactionServices.getTransactionByTransactionId(1);
        System.out.println(transactions.toString());
    }
}