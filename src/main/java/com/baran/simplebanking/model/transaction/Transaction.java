package com.baran.simplebanking.model.transaction;

import com.baran.simplebanking.model.BankAccount;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    protected Instant date;
    protected double amount;
    protected String type = getClass().getSimpleName();
    protected UUID approvalCode;
    @ManyToOne
    @JoinColumn(name = "account_number")
    @JsonBackReference
    private BankAccount bankAccount;

    public Transaction(double amount) {
        this.date = Instant.now();
        this.amount = amount;
        approvalCode = UUID.randomUUID();
    }

    public void apply(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        performTransaction(bankAccount);
    }

    protected abstract void performTransaction(BankAccount bankAccount);


    @Override
    public String toString() {
        return "Transaction [date=" + date + ", amount=" + amount + "]";
    }
}

