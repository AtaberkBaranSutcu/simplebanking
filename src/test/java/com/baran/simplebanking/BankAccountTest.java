package com.baran.simplebanking;


import com.baran.simplebanking.model.BankAccount;
import com.baran.simplebanking.model.transaction.DepositTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount("Ataberk Baran", 1000.0);
    }

    @Test
    void testBankAccountCreation() {
        assertEquals("Ataberk Baran", bankAccount.getOwner());
        assertEquals(1000.0, bankAccount.getBalance());
        assertNull(bankAccount.getAccountNumber());
        assertNull(bankAccount.getCreateDate());
        assertTrue(bankAccount.getTransactions().isEmpty());
    }

    @Test
    void testCredit() {
        bankAccount.credit(200.0);
        assertEquals(1200.0, bankAccount.getBalance());
    }

    @Test
    void testDebit() {
        bankAccount.debit(300.0);
        assertEquals(700.0, bankAccount.getBalance());
    }

    @Test
    void testPost() {
        bankAccount.post(new DepositTransaction(150));
        assertFalse(bankAccount.getTransactions().isEmpty());
        assertEquals(1150.0, bankAccount.getBalance());
    }

}
