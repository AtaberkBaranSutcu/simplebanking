package com.baran.simplebanking.model.transaction;

import com.baran.simplebanking.model.BankAccount;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class DepositTransaction extends Transaction {
    public DepositTransaction(double amount) {
        super(amount);
        type = getClass().getSimpleName();
    }

    @Override
    protected void performTransaction(BankAccount bankAccount) {
        bankAccount.credit(amount);
    }

    @Override
    public String toString() {
        return "DepositTransaction [date=" + date + ", amount=" + amount + "]";
    }
}

