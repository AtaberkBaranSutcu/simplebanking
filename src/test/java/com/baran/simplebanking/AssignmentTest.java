package com.baran.simplebanking;

import com.baran.simplebanking.model.BankAccount;
import com.baran.simplebanking.model.transaction.DepositTransaction;
import com.baran.simplebanking.model.transaction.PhoneBillPaymentTransaction;
import com.baran.simplebanking.model.transaction.WithdrawalTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignmentTest {

    // I took this test from the assignment you shared.
    // It appears that when the BankAccount object is created, the first parameter is a String (owner), and the second parameter is a numeric value.
    // In the text and diagram you shared, the only numeric value mentioned is the Balance.
    // Therefore, when we consider the first parameter as the owner and the second parameter as the balance while creating the BankAccount object,
    // we observe that the actual value in the test is not 703.50 but should be 13048.5.
    @Test
    public void assignmentTest() {
        BankAccount account = new BankAccount("Jim", 12345);
        account.post(new DepositTransaction(1000));
        account.post(new WithdrawalTransaction(200));
        account.post(new PhoneBillPaymentTransaction("Vodafone", "5423345566", 96.50));
        assertEquals(account.getBalance(), 13048.5, 0.0001);
    }
}
