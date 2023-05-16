package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, String> {
//    // JPQL
//    @Query("from Account where number =?1")
//    Account loadAccount(String number);
//    @Query("update Account set balance =?1 where number =?2")
//    void updateAccount(Account account);
}
