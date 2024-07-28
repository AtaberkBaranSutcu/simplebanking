package com.baran.simplebanking.service.impl;

import com.baran.simplebanking.dto.AmountDTO;
import com.baran.simplebanking.model.BankAccount;
import com.baran.simplebanking.model.transaction.DepositTransaction;
import com.baran.simplebanking.model.transaction.Transaction;
import com.baran.simplebanking.model.transaction.WithdrawalTransaction;
import com.baran.simplebanking.repository.BankAccountRepository;
import com.baran.simplebanking.service.BankAccountService;
import com.baran.simplebanking.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public ResponseEntity createBankAccount(BankAccount bankAccount) {
        bankAccount = bankAccountRepository.save(bankAccount);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "OK");
        response.put("accountNumber", bankAccount.getAccountNumber());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity depositMoney(String accountNumber, AmountDTO amountDTO) {
        Validator.validateAccountNumber(accountNumber);
        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
        Validator.validateBankAccount(bankAccount);
        Transaction transaction = new DepositTransaction(amountDTO.getAmount());
        bankAccount.post(transaction);
        bankAccountRepository.save(bankAccount);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "OK");
        response.put("accountNumber", bankAccount.getAccountNumber());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity withdrawMoney(String accountNumber, AmountDTO amountDTO) {
        Validator.validateAccountNumber(accountNumber);
        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
        Validator.validateBankAccount(bankAccount);
        Transaction transaction = new WithdrawalTransaction(amountDTO.getAmount());
        bankAccount.post(transaction);
        bankAccountRepository.save(bankAccount);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "OK");
        response.put("approvalCode", transaction.getApprovalCode());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity readBankAccount(String accountNumber) {
        Validator.validateAccountNumber(accountNumber);
        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
        Validator.validateBankAccount(bankAccount);
        return ResponseEntity.ok(bankAccount);
    }

    @Override
    public ResponseEntity readBankAccounts(Pageable pageable) {
        Page<BankAccount> pageOfBankAccounts = bankAccountRepository.findAll(pageable);
        return ResponseEntity.ok(pageOfBankAccounts);
    }
}
