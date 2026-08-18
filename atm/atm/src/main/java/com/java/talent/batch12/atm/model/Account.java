package com.java.talent.batch12.atm.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true) //(to ensure parent fields are included)
@Entity // (mark as a subclass of superclass)
@Table(name = "accounts") // (create table and table name)
@Data


public class Account extends AbstractEntity{

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private int accountId;

    @Column(name = "username", nullable = false, length = 512) // column
    private String username;
    @Column(name = "password", nullable = false, length = 512)
    private String password;
    @Column(name = "balance")
    private double balance;
    @Column(name = "address", length = 1000)
    private String address;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Account{");
        sb.append("accountId=").append(accountId);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", address='").append(address).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}