package services;

import Models.Account;

public interface AccountService {

    public Account createAccount(String customerName,String accountType, double initialBalance);

    public void deposit(double initialBalance);
//
//    public void withdrawal(int amount);
//
//    public void bankBalance();
//
//    public void deleteAccount();
}
