package com.example.controller;

import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.TransferService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public String transfer() {

       Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
       System.out.println(authentication.getName());
       authentication.getAuthorities().forEach(System.out::println);

        return "transfer-form";
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public ModelAndView transfer(
            @RequestParam String fromAccountNumber,
            @RequestParam String toAccountNumber,
            @RequestParam double amount) {
            transferService.transfer(fromAccountNumber, toAccountNumber, amount);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("status", "success");
            modelAndView.setViewName("transfer-status");
        return modelAndView;
    }

    @ExceptionHandler(value = {AccountNotFoundException.class, AccountBalanceException.class})
    public ModelAndView handleException(Exception e){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("error");
        return modelAndView;
    }


}
