package com.baran.simplebanking.validation;

import com.baran.simplebanking.exception.BankAccountNotFoundException;
import com.baran.simplebanking.exception.InsufficientBalanceException;
import com.baran.simplebanking.model.BankAccount;

import java.util.UUID;

public class Validator {
    public static void validateAccountNumber(String accountNumber) {
        if (accountNumber == null) {
            throw new IllegalArgumentException("Account number cannot be null");
        }
        try {
            UUID.fromString(accountNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid account number format");
        }
    }

    public static void validateBankAccount(BankAccount bankAccount) {
        if (bankAccount == null) {
            throw new BankAccountNotFoundException("Bank account not found");
        }
    }

    public static void validateBalance(double balance, double amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
    }
}
