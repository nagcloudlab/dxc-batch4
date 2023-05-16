package com.example.repository;

import com.example.entity.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaAccountRepository implements AccountRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account loadAccount(String number) {
        return entityManager.find(Account.class, number);
    }

    @Override
    public void updateAccount(Account account) {
        entityManager.merge(account);
    }
}
