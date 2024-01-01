package com.banking;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private double amount;
    private String type;


    public Transaction(LocalDate date, double amount, String type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isType(String type) {
        return this.type.equals(type);
    }
    public boolean isAfter(LocalDate date) {
        return this.date.equals(date);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
