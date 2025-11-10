package services;

import Models.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountServiceImpl implements AccountService{

    @Override
    public Account createAccount(String customerName,String accountType, double initialBalance) {

        long accountNumber = 10000000000L + (long)(Math.random() * 90000000000L);

        return new Account(customerName,accountNumber,accountType,initialBalance);
    }

    @Override
    public void deposit(double initialBalance) {

    }

}
