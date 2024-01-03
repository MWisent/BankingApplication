package com.banking;

import com.banking.Interfaces.BankingOperations;
import com.banking.enums.AccountStatus;
import com.banking.enums.AccountType;
import com.banking.enums.TransactionType;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Account implements BankingOperations {
    private String accountNumber;
    private double balance;
    private Customer accountHolder;
    private AccountStatus status;
    private AccountType accountType;
    private LocalDate  dateOfOpening;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber, double balance,
                   Customer accountHolder, AccountStatus status,
                   AccountType accountType, LocalDate dateOfOpening,
                   List<Transaction> transactionHistory) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.status = status;
        this.accountType = accountType;
        this.dateOfOpening = dateOfOpening;
        this.transactionHistory = transactionHistory;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(Customer accountHolder) {
        this.accountHolder = accountHolder;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public LocalDate getDateOfOpening() {
        return dateOfOpening;
    }

    public void setDateOfOpening(LocalDate dateOfOpening) {
        this.dateOfOpening = dateOfOpening;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Kwota wpłaty musi być dodatnia");
            return false;
        }
        this.balance += amount;
        // Dodanie trazakcji
        Transaction transaction = new Transaction(LocalDate.now(), amount, TransactionType.DEPOSIT);
        this.transactionHistory.add(transaction);
        return true;
    }
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Kwota wypłaty musi być dodatnia");
            return false;
        }
        this.balance -= amount;

        Transaction transaction = new Transaction(LocalDate.now(), amount, TransactionType.WITHDRAW);
        this.transactionHistory.add(transaction);
        return true;
    }
    @Override
    public boolean transfer(Account targetAccount, double amount) {
        // Sprawdzanie, czy saldo jest wystarczające i czy kwota jest dodatnia
        if (this.balance >= amount && amount > 0) {
            // Sprawdzenie, czy konto docelowe nie jest tym samym kontem.
            if (!this.equals(targetAccount)) {
                // Odjęcie kwoty z bieżącego konta
                this.balance -= amount;
                // dodanie kwoty do konta docelowego
                targetAccount.setBalance(targetAccount.getBalance() + amount);

                // Dodajemy tranzakcję do bieżącego konta
                Transaction outgoingTransaction = new Transaction(LocalDate.now(), amount, TransactionType.TRANSFER_OUT);
                this.transactionHistory.add(outgoingTransaction);
                // Dodajemy tranzakcję do docelowego konta
                Transaction incomingTransaction = new Transaction(LocalDate.now(), amount, TransactionType.TRANSFER_IN);
                this.transactionHistory.add(incomingTransaction);


                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(accountHolder, account.accountHolder) && status == account.status && accountType == account.accountType && Objects.equals(dateOfOpening, account.dateOfOpening) && Objects.equals(transactionHistory, account.transactionHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance, accountHolder, status, accountType, dateOfOpening, transactionHistory);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", accountHolder=" + accountHolder +
                ", status=" + status +
                ", accountType=" + accountType +
                ", dateOfOpening=" + dateOfOpening +
                ", transactionHistory=" + transactionHistory +
                '}';
    }

}
