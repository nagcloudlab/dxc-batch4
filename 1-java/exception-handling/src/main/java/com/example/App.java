package com.example;

//--------------------------------------------------
// team-1: money transfer module
//--------------------------------------------------
class AccountNotFoundException extends RuntimeException {
    AccountNotFoundException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "account not found";
    }
}
class AccountBalanceException extends RuntimeException {
    double balance;
    AccountBalanceException(double balance) {
        this.balance = balance;
    }
    @Override
    public String getMessage() {
        return "not enough money to transfer, current balance is "+balance;
    }
}

class MoneyTransfer {
    public boolean transfer(double amount, String source, String destination) /*throws AccountBalanceException */{

        if(source.equals("13")){
            throw new AccountNotFoundException("133");
        }
        double sourceAccBalance= 1000.00;
        // condition: sourceAccountBalance >= amount
        if(sourceAccBalance<amount){
            throw new AccountBalanceException(sourceAccBalance);
        }
        // debit
        // credit
        // update accounts
        return true;
    }
}



//--------------------------------------------------
// team-2: ticket booking module
//--------------------------------------------------

class TicketBooking {
    MoneyTransfer moneyTransfer=new MoneyTransfer();
    public void bookTicket(double ticketAmount,String source,String destination) {
        try {
            moneyTransfer.transfer(ticketAmount, source, destination);
            // confirm ticket
            System.out.println("ticket booked successfully");
            // connected any external system ( like database
        }catch (AccountBalanceException | AccountNotFoundException e) {
            // provide user-friendly messages to end user
            // log exception for future fix
            // re-throw exception
            // ....
            System.out.println("Ex-"+e.getMessage());
            System.out.println("ticket booked unsuccessfully");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // close connection | clean any resource that use try block
        }

    }
}

public class App {
    public static void main(String[] args) {

        TicketBooking ticketBooking=new TicketBooking();
        ticketBooking.bookTicket(5000.00,"13","456");

        try {
            int a = 12;
            int b = 0;
            int c = a / b;
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

//        int[] arr={1,2,3};
//        System.out.println(arr[3]);

//        Employee employee=null;
//        employee.doWork();
    }
}

class Employee {
    void doWork() {
        System.out.println("do work");
    }
}