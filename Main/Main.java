package Main;

import Models.Account;
import services.AccountServiceImpl;

import java.util.*;

public class Main {
    static AccountServiceImpl accountService = new AccountServiceImpl();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        System.out.println("=== Welcome to Simple Bank System ===");
        while (running) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> createAccount();
                case 2 -> depositAmount();
                case 3 -> withdrawalAmount();
                case 4 -> deleteAccount();
                default -> System.out.println("enter a valid choice");
            }
        }
        Account newAccount = accountService.createAccount("Padmalochana Polaki","Savings",99999.99999);
        System.out.println("Your account has been created");
        System.out.println(newAccount);
    }
    private static void showMenu() {
        System.out.println("\n1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. View Account Details");
        System.out.println("6. Exit");
    }

    public static void createAccount(){
        Map<Long,Account> accounts= new HashMap<>();

        System.out.print("Enter Customer ID: ");
        String customerName = sc.nextLine();
        System.out.print("Enter Account Type (SAVINGS/CURRENT): ");
        String type = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Account account = accountService.createAccount(customerName,type,balance);

        System.out.println("Your account has been created");
        accounts.put(account.getAccountNumber(),account);

        System.out.println("------------------------------");
        System.out.println("Account details");
        for(Map.Entry<Long,Account> entry : accounts.entrySet()){
            Account acc = entry.getValue();
            System.out.println("------------------------------");
            System.out.println("customerName : " + acc.getCustomerName());
            System.out.println("accountNumber : " + acc.getAccountNumber());
            System.out.println("accountType : " + acc.getAccountType());
            System.out.println("balance : " + acc.getBalance());
            System.out.println("status : " + acc.getStatus());
            System.out.println("------------------------------");
        }

    }

    public static void depositAmount(){
        System.out.println("amount deposited");
    }

    public static void withdrawalAmount(){
        System.out.println("amount withdrawal is happening ");
    }
    public static void deleteAccount(){
        System.out.println("account has been deleted");
    }
}
