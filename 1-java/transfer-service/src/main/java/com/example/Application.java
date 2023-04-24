package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.AccountRepositoryFactory;
import com.example.repository.MongoAccountRepository;
import com.example.service.UPITransferService;

public class Application {
    public static void main(String[] args) {

        //------------------------------------------------
        // init / booting phase
        //------------------------------------------------
        System.out.println("-".repeat(100));
        AccountRepository accountRepository = AccountRepositoryFactory.getAccountRepository("jdbc"); // dependency
        //UPITransferService transferService=new UPITransferService(new MongoAccountRepository());
        UPITransferService transferService = new UPITransferService(accountRepository); // dependent
        System.out.println("-".repeat(100));
        //------------------------------------------------
        // business logic phase
        //------------------------------------------------

        transferService.transfer(100.0, "1", "2");
        System.out.println();
        transferService.transfer(100.0, "2", "1");


        //------------------------------------------------
        // end phase
        //------------------------------------------------
        System.out.println("-".repeat(100));
        System.out.println("-".repeat(100));


    }
}
