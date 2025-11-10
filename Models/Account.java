package Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private String customerName;
    private Long accountNumber;
    private String accountType;
    private double balance;
    private String status;
    private LocalDateTime lastTransactionDate;
    private List<Transaction> transactionList;

    public Account(String customerName, Long accountNumber, String accountType, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.status = "ACTIVE";
        this.lastTransactionDate = LocalDateTime.now();
        this.transactionList = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   

    public LocalDateTime getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(LocalDateTime lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(customerName, account.customerName) && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(accountType, account.accountType) && Objects.equals(status, account.status) && Objects.equals(lastTransactionDate, account.lastTransactionDate) && Objects.equals(transactionList, account.transactionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, accountNumber, accountType, balance, status, lastTransactionDate, transactionList);
    }

    @Override
    public String toString() {
        return "Account{" +
                "customerName='" + customerName + '\'' +
                ", accountNumber=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", status='" + status + '\'' +
                ", lastTransactionDate=" + lastTransactionDate +
                ", transactionList=" + transactionList +
                '}';
    }
}
