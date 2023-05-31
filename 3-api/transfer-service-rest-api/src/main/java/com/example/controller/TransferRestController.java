package com.example.controller;

import com.example.controller.dto.TransferRequest;
import com.example.controller.dto.TransferResponse;
import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import com.example.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class TransferRestController {

    private final TransferService transferService;

    @RequestMapping(value = "/api/transfer", method = RequestMethod.POST)
    public TransferResponse transfer(@RequestBody TransferRequest transferRequest) {
        transferService.transfer(transferRequest.getFromAccountNumber(), transferRequest.getToAccountNumber(), transferRequest.getAmount());
        TransferResponse transferResponse=new TransferResponse();
        transferResponse.setMessage("success");
        return transferResponse;
    }

    @ExceptionHandler(value = {AccountNotFoundException.class, AccountBalanceException.class})
    public ResponseEntity<?> handleException(Exception e){
        if(e instanceof AccountNotFoundException){
            return ResponseEntity.badRequest().body("account number invalid -"+e.getMessage());
        }else if(e instanceof AccountBalanceException){
            return ResponseEntity.badRequest().body("no enough fund , current-balance - "+e.getMessage());
        }
        return ResponseEntity.badRequest().body("error");
    }



}
