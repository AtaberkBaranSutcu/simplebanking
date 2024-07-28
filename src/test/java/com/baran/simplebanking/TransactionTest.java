package com.baran.simplebanking;

import com.baran.simplebanking.model.transaction.BillPaymentTransaction;
import com.baran.simplebanking.model.transaction.DepositTransaction;
import com.baran.simplebanking.model.transaction.PhoneBillPaymentTransaction;
import com.baran.simplebanking.model.transaction.WithdrawalTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {
    @Test
    void testDepositTransaction() {
        int expectedAmount = 150;
        DepositTransaction transaction = new DepositTransaction(expectedAmount);
        assertEquals(expectedAmount, transaction.getAmount());
        assertEquals("DepositTransaction", transaction.getType());
        assertNotNull(transaction.getDate());
        assertNotNull(transaction.getApprovalCode());
        assertNull(transaction.getBankAccount());
    }

    @Test
    void testWithdrawalTransaction() {
        int expectedAmount = 250;
        WithdrawalTransaction transaction = new WithdrawalTransaction(expectedAmount);
        assertNotEquals(300, transaction.getAmount());
        assertEquals("WithdrawalTransaction", transaction.getType());
        assertNotNull(transaction.getDate());
        assertNotNull(transaction.getApprovalCode());
        assertNull(transaction.getBankAccount());
    }

    @Test
    void testBillPaymentTransaction() {
        String expectedPayee = "Turkcell";
        int expectedAmount = 200;
        BillPaymentTransaction transaction = new BillPaymentTransaction(expectedAmount, expectedPayee);
        assertEquals(expectedAmount, transaction.getAmount());
        assertEquals("BillPaymentTransaction", transaction.getType());
        assertNotNull(transaction.getDate());
        assertNotNull(transaction.getApprovalCode());
        assertNull(transaction.getBankAccount());
        assertEquals(expectedPayee, transaction.getPayee());
    }

    @Test
    void testPhoneBillPaymentTransaction() {
        String expectedNumber = "5078591444";
        String expectedPayee = "Vodafone";
        int expectedAmount = 450;
        PhoneBillPaymentTransaction transaction = new PhoneBillPaymentTransaction(expectedPayee, expectedNumber, expectedAmount);
        assertEquals(expectedAmount, transaction.getAmount());
        assertEquals("PhoneBillPaymentTransaction", transaction.getType());
        assertNotNull(transaction.getDate());
        assertNotNull(transaction.getApprovalCode());
        assertNull(transaction.getBankAccount());
        assertEquals(expectedPayee, transaction.getPayee());
        assertEquals(expectedNumber, transaction.getNumber());
    }
}
