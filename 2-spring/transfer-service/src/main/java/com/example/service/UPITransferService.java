package com.example.service;

import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

import javax.annotation.security.RolesAllowed;

@Service
@RequiredArgsConstructor
public class UPITransferService implements TransferService {

    private final AccountRepository accountRepository;

    @RolesAllowed("ROLE_ADMIN")
    @Transactional
    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {

        Account fromAccount = accountRepository.findById(fromAccountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account not found " + fromAccountNumber));

        Account toAccount = accountRepository.findById(toAccountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account not found " + toAccountNumber));

        if(fromAccount.getBalance() < amount)
            throw new AccountBalanceException("Insufficient balance in account " + fromAccount.getBalance());

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

    }

}
