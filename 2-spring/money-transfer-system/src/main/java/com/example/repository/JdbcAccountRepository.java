package com.example.repository;

import com.example.model.Account;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;

//@Component("jdbcAccountRepository")
@Repository("jdbcAccountRepository")
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(JdbcAccountRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account loadAccount(String number) {
        logger.info("loadAccount: {}", number);
        return jdbcTemplate.queryForObject("select * from accounts where number=?", (rs, index) -> {
            return new Account(rs.getString("number"), rs.getDouble("balanace"));
        }, number);
    }

    @Override
    public void updateAccount(Account account) {
        logger.info("saveAccount: {}", account.getNumber());
        jdbcTemplate.update("update accounts set balanace=? where number=?", account.getBalance(), account.getNumber());
    }
}
