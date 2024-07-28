package com.baran.simplebanking.service;

import com.baran.simplebanking.dto.AmountDTO;
import com.baran.simplebanking.model.BankAccount;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface BankAccountService {
    ResponseEntity createBankAccount(BankAccount bankAccount);

    ResponseEntity depositMoney(String accountNumber, AmountDTO amountDTO);

    ResponseEntity withdrawMoney(String accountNumber, AmountDTO amountDTO);

    ResponseEntity readBankAccount(String accountNumber);

    ResponseEntity readBankAccounts(Pageable pageable);
}
