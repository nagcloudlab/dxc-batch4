package com.example.repository;

// factory class
public class AccountRepositoryFactory {

    // factory method
    public static AccountRepository getAccountRepository(String dbTech) {
        if (dbTech.equalsIgnoreCase("jdbc")) {
            return new JdbcAccountRepository();
        }
        if (dbTech.equalsIgnoreCase("jpa")) {
            return new JpaAccountRepository();
        }
        return null;
    }

}
