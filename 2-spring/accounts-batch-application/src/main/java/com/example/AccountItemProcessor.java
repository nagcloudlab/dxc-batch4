package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class AccountItemProcessor implements ItemProcessor<Account,Account> {
    @Override
    public Account process(Account account) throws Exception {
        log.info("Processing account information: {}", account);
        if(account.getBalance()<0){
            account.setBalance(0);
        }
        return account;
    }
}
