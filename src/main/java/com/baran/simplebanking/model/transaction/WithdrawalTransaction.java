package com.baran.simplebanking.model.transaction;

import com.baran.simplebanking.model.BankAccount;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(double amount) {
        super(amount);
        type = getClass().getSimpleName();
    }

    @Override
    protected void performTransaction(BankAccount bankAccount) {
        bankAccount.debit(amount);
    }

    @Override
    public String toString() {
        return "WithdrawalTransaction [date=" + date + ", amount=" + amount + "]";
    }
}

