package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.apache.log4j.Logger;

/**
 * author : Team-2
 */

public class UPITransferService {

    private final static Logger logger = Logger.getLogger("mts");
    private AccountRepository accountRepository;

    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("UPITransferService component created");
    }

    public void transfer(double amount, String source, String destination) {
        logger.info("Transferring " + amount + " from " + source + " to " + destination);

        //JdbcAccountRepository accountRepository = new JdbcAccountRepository(); // creating dependency object
        //AccountRepository accountRepository = AccountRepositoryFactory.getAccountRepository("jdbc");

        // load source & destination account details
        Account sourceAccount = accountRepository.loadAccount(source);
        Account destinationAccount = accountRepository.loadAccount(destination);

        // debit & credit
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        logger.info("debit & credit");

        // update accounts
        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(destinationAccount);

        logger.info("Transferred " + amount + " from " + source + " to " + destination);
    }

}
