package com.baran.simplebanking.model.transaction;

import com.baran.simplebanking.model.BankAccount;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class BillPaymentTransaction extends Transaction {
    public String payee;

    public BillPaymentTransaction(double amount, String payee) {
        super(amount);
        this.payee = payee;
        type = getClass().getSimpleName();
    }

    @Override
    protected void performTransaction(BankAccount bankAccount) {
        bankAccount.debit(amount);
    }

    @Override
    public String toString() {
        return "BillPaymentTransaction [date=" + date + ", amount=" + amount + ", payee=" + payee + "]";
    }
}

