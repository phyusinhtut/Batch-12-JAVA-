package com.java.talent.batch12.atm.model;

import com.java.talent.batch12.atm.model.enumType.TransactionType;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true) // to ensure parent fields are included
@Entity // mark as a subclass of a superclass
@Table(name ="transactions") // create table and table name
@Data
@NoArgsConstructor
public class Transaction extends  AbstractEntity{

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int transactionId;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "account_id", nullable = false)
    private int accountId;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Transaction{");
        sb.append("accountId=").append(accountId);
        sb.append("transactionId=").append(transactionId);
        sb.append(", amount=").append(amount);
        sb.append(", type='").append(transactionType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}