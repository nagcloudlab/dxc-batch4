package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("upiTransferService")
@Service("upiTransferService")
public class UPITransferService implements TransferService {

    private static final Logger logger = LoggerFactory.getLogger(TransferService.class);
    private final AccountRepository accountRepository;

    @Autowired
    public UPITransferService(@Qualifier("jdbc") AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("UPITransferService created");
    }

    @Override
    public boolean transfer(double amount, String source, String destination) {
        logger.info("transfer initiated");
        // step-1 : Load source account
        Account sourceAccount = accountRepository.loadAccount(source);
        // step-2 : Load destination account
        Account destinationAccount = accountRepository.loadAccount(destination);
        // step-3 : debit & credit
        if(amount> sourceAccount.getBalance())
            throw new RuntimeException("Insufficient funds");
        logger.info("debit");
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        logger.info("credit");
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        // step-4 : Update source & destination accounts
        accountRepository.saveAccount(sourceAccount);
        accountRepository.saveAccount(destinationAccount);
        logger.info("transfer completed");
        return true;
    }
}
