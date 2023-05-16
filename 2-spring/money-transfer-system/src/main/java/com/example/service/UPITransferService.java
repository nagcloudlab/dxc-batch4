package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Component("upiTransferService")
@Service("upiTransferService")
public class UPITransferService implements TransferService {

    private static final Logger logger = LoggerFactory.getLogger(TransferService.class);
    private final AccountRepository accountRepository;

    @Value("${transfer.limit: 1000.00}")
    private double transferLimit;

    @Autowired
    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("UPITransferService created");
    }

    @Transactional
    @Override
    public boolean transfer(double amount, String source, String destination) {
        logger.info("transfer initiated");
        logger.info("transferLimit: " + transferLimit);
        // amount <= transferLimit
        // step-1 : Load source account
        Account sourceAccount = accountRepository.findById(source)
                .orElseThrow(() -> new RuntimeException("Source account not found"));
        // step-2 : Load destination account
        Account destinationAccount = accountRepository.findById(destination)
                .orElseThrow(() -> new RuntimeException("Destination account not found"));
        // step-3 : debit & credit
        if(amount> sourceAccount.getBalance())
            throw new RuntimeException("Insufficient funds");
        logger.info("debit");
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        logger.info("credit");
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        // step-4 : Update source & destination accounts
        accountRepository.save(sourceAccount);
        accountRepository.save(destinationAccount);
        logger.info("transfer completed");
        return true;
    }
}
