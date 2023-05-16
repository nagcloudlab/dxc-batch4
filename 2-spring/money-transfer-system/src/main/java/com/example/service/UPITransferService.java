package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UPITransferService implements TransferService {

    private final AccountRepository accountRepository;

    @Transactional
    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {

        Account fromAccount = accountRepository.findById(fromAccountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Account not found " + fromAccountNumber));

        Account toAccount = accountRepository.findById(toAccountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Account not found " + toAccountNumber));

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

    }

}
