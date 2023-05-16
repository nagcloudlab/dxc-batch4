package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.TransferService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public String transfer(
            @RequestParam String fromAccountNumber,
            @RequestParam String toAccountNumber,
            @RequestParam double amount) {
        transferService.transfer(fromAccountNumber, toAccountNumber, amount);
        return "redirect:/transfer-status.html";
    }

}
