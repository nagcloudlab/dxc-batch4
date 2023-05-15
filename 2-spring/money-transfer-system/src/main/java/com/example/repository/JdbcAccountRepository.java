package com.example.repository;

import com.example.model.Account;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private DataSource dataSource;

    @Override
    public Account loadAccount(String number) {
        logger.info("loadAccount: {}", number);
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            logger.info("connection with mysql-server success");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return new Account(number, 1000.00);
    }

    @Override
    public void saveAccount(Account account) {
        logger.info("saveAccount: {}", account.getNumber());
        //..
    }
}
