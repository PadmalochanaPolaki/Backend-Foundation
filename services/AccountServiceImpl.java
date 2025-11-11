package services;

import Models.Account;
import Models.Transaction;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AccountServiceImpl implements AccountService{
    private Map<Long, Account> accounts = new HashMap<>();

    @Override
    public Account createAccount(String customerName,String accountType, double initialBalance) {

        long accountNumber = 10000000000L + (long)(Math.random() * 90000000000L);
        Account account = new Account(customerName,accountNumber,accountType,initialBalance);
        accounts.put(accountNumber,account);
        return account;
    }

    @Override
    public Account deposit(long accountNumber, double amount) {

        if (!accounts.containsKey(accountNumber)) {
           throw new RuntimeException("Account is not exists, enter a valid account number");
        }
        Account account = accounts.get(accountNumber);

        if(!account.getStatus().equalsIgnoreCase("ACTIVE")){
            throw new RuntimeException("Account is not active");
        }

        if(amount <= 0){
            throw new RuntimeException("Amount cannot be lower than or equal to zero");
        }

        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        account.setLastTransactionDate(LocalDateTime.now());

        Transaction transaction = new Transaction(accountNumber,"DEPOSIT");
        transaction.setAmount(amount);
        account.getTransactionList().add(transaction);

        return account;

    }

    @Override
    public Account withdrawal(long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);

        if(amount > account.getBalance()){
            throw new RuntimeException("Withdraw amount cannot exceed balance");
        }

        if (!accounts.containsKey(accountNumber)) {
            throw new RuntimeException("Account is not exists, enter a valid account number");
        }

        if(!account.getStatus().equalsIgnoreCase("ACTIVE")){
            throw new RuntimeException("Account is not active");
        }

        if(amount <= 0){
            throw new RuntimeException("Amount cannot be lower than or equal to zero");
        }

        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);

        account.setLastTransactionDate(LocalDateTime.now());

        Transaction transaction = new Transaction(accountNumber,"DEPOSIT");
        account.getTransactionList().add(transaction);

        return account;

    }



}
