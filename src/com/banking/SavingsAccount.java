package com.banking;

import com.banking.enums.AccountStatus;
import com.banking.enums.AccountType;
import com.banking.enums.TransactionType;

import java.time.LocalDate;
import java.util.List;

public class SavingsAccount extends Account {
    private int interestRate;

    public SavingsAccount(
            String accountNumber, double balance,
            Customer accountHolder, AccountStatus status,
            AccountType accountType, LocalDate dateOfOpening,
            List<Transaction> transactionHistory, int interestRate
    ) {
        super(accountNumber, balance, accountHolder, status, accountType, dateOfOpening, transactionHistory);
        this.interestRate = interestRate;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return this.getBalance() * (interestRate / 100.0);
    }

    public void applyInterest() {
        double interest = calculateInterest();
        this.setBalance(this.getBalance() + interest);

        // Tworzenie tranzakcji odsetek
        Transaction interestTransaction = new Transaction(LocalDate.now(), interest, TransactionType.INTEREST);
        getTransactionHistory().add(interestTransaction);
    }

}
