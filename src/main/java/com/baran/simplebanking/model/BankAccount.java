package com.baran.simplebanking.model;

import com.baran.simplebanking.model.transaction.Transaction;
import com.baran.simplebanking.validation.Validator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class BankAccount {
    @Id
    private String accountNumber;
    private String owner;
    @Min(value = 0, message = "Amount must be greater than or equal to 0")
    private double balance;
    private Instant createDate;
    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Transaction> transactions = new ArrayList<>();

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    @PrePersist
    protected void onCreate() {
        this.accountNumber = UUID.randomUUID().toString();
        createDate = Instant.now();
    }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) {
        Validator.validateBalance(balance, amount);
        this.balance -= amount;
    }

    public void post(Transaction transaction) {
        transaction.apply(this);
        transactions.add(transaction);
    }
}
