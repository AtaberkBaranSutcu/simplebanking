package com.baran.simplebanking.controller;

import com.baran.simplebanking.dto.AmountDTO;
import com.baran.simplebanking.model.BankAccount;
import com.baran.simplebanking.service.BankAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/account/v1")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping("/{accountNumber}")
    public ResponseEntity readBankAccount(@PathVariable String accountNumber) {
        return bankAccountService.readBankAccount(accountNumber);
    }

    @GetMapping
    public ResponseEntity readBankAccounts(Pageable pageable) {
        return bankAccountService.readBankAccounts(pageable);
    }

    @PostMapping
    public ResponseEntity createBankAccount(@Valid @RequestBody BankAccount bankAccount) {
        return bankAccountService.createBankAccount(bankAccount);
    }

    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity depositMoney(@PathVariable String accountNumber, @Valid @RequestBody AmountDTO amountDTO) {
        return bankAccountService.depositMoney(accountNumber, amountDTO);
    }

    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity withdrawMoney(@PathVariable String accountNumber, @Valid @RequestBody AmountDTO amountDTO) {
        return bankAccountService.withdrawMoney(accountNumber, amountDTO);
    }
}