package com.baran.simplebanking.model.transaction;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PhoneBillPaymentTransaction extends BillPaymentTransaction {
    private String number;

    public PhoneBillPaymentTransaction(String payee, String number, double amount) {
        super(amount, payee);
        this.number = number;
        type = getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "PhoneBillPaymentTransaction [date=" + date + ", number=" + number + ", amount=" + amount + ", payee=" + payee + "]";
    }

}
