package com.baran.simplebanking;

import com.baran.simplebanking.exception.InsufficientBalanceException;
import com.baran.simplebanking.validation.Validator;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ValidatorTest {

    @Test
    public void validateAccountNumber_nullAccountNumber_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAccountNumber(null));
    }

    @Test
    public void validateAccountNumber_invalidFormatAccountNumber_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAccountNumber("12345"));
    }

    @Test
    public void validateAccountNumber_validFormatAccountNumber_noExceptionThrown() {
        Validator.validateAccountNumber(UUID.randomUUID().toString());
    }

    @Test
    public void validateBalance_validBalance_noExceptionThrown() {
        Validator.validateBalance(1000, 500);
    }

    @Test
    public void validateBalance_invalidBalance_throwsInsufficientBalanceException() {
        assertThrows(InsufficientBalanceException.class, () -> Validator.validateBalance(1000, 1500));
    }
}