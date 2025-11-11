package services;

import Models.Account;

public interface AccountService {

    public Account createAccount(String customerName,String accountType, double initialBalance);

    public Account deposit(long accountNumber, double amount);
//
    public Account withdrawal(long accountNumber, double amount);
//
//    public void bankBalance();
//
//    public void deleteAccount();
}
