package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;

/**
 * author : Team-1
 */

public class JdbcAccountRepository implements  AccountRepository{

    private final static Logger logger = Logger.getLogger("mts");

    public JdbcAccountRepository() {
        logger.info("JdbcAccountRepository component created");
    }

    public Account loadAccount(String number) {
        logger.info("loadAccount-" + number);
        // TODO
        return new Account(number, 1000.00);
    }

    public void updateAccount(Account account) {
        logger.info("updateAccount-" + account.getNumber());
        // TODO
    }

}
