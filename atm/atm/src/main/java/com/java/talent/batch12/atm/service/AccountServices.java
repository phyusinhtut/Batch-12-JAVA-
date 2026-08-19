package com.java.talent.batch12.atm.service;

import com.java.talent.batch12.atm.model.Account;
import com.java.talent.batch12.atm.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountServices {
    private final AccountRepository accountRepository;

    public Account createAccount(String userName, String password, String email, String address) {
        userName = userName.trim();
        password = password.trim();
        email = email.trim();
        String trimmedAddress = (address == null) ? "" : address.trim();

        if (!userName.matches("[a-zA-Z]+")) {
            System.out.println("Username must contain only letters (A-Z, a-z). No numbers allowed.");
        }

        if (userName.isEmpty()) {
            System.out.println("Username cannot be empty.");
        }

        if (password.isEmpty()) {
            System.out.println("Password cannot be empty.");
        }

        if (email.isEmpty()) {
            System.out.println("Email cannot be empty.");
        }
        if(address.isEmpty())
        {
            System.out.println("Address cannot be empty");
        }

        Account account = new Account();
        account.setUsername(userName);
        account.setPassword(password);
        account.setEmail(email);
        account.setAddress(address);
        return accountRepository.save(account);

    }

    public boolean loginAccount(String userName, String password) {
        userName = userName.trim();
        password = password.trim();

        Account currentAccount = accountRepository.findByUsername(userName);
        if (currentAccount == null) {
            System.out.println("User not found: " + userName);
            return false;
        }

        String loginPass = currentAccount.getPassword();
        if (loginPass.equals(password)) {
            return true;
        }
        return false;
    }

    public boolean deleteAccount(String userName, String password) {
        userName = userName.trim();
        password = password.trim();

        if (userName.isEmpty() || password.isEmpty()) {
            System.out.println("Username or password cannot be empty");
            return false;
        }

        Account account = accountRepository.findByUsername(userName);

        if (account == null) {
            System.out.println("Account not found: " + userName);
            return false;
        }

        if (!account.getPassword().equals(password)) {
            System.out.println("Incorrect password for: " + userName);
            return false;
        }
        account.setDeleted_at(LocalDateTime.now());
        accountRepository.save(account);
        System.out.println("Account deleted successfully: " + userName);
        return true;

    }

    public Account getAccountByUserName(String userName) {

        if(userName == null )
        {
            System.out.println("UseName cannot be empty");
            return null;
        }
        userName = userName.trim();
        Account account = accountRepository.findByUsername(userName);

        if (account == null)
        {
            System.out.println("Account not found: " + userName);
            return null;
        }
        return account;

    }

    public double updateBalance(String userName, double newBalance) {
        if (userName == null || userName.trim().isEmpty()) {
            System.out.println("Username cannot be empty");
        }
        if (newBalance < 0) {
            System.out.println("Balance cannot be negative");
        }
        assert userName != null;
        userName = userName.trim();
        Account account = accountRepository.findByUsername(userName);
        if (account == null) {
            System.out.println("Account not found: " + userName);
        }
        assert account != null;
        account.setBalance(newBalance);
        accountRepository.save(account);
        return newBalance;
    }
}