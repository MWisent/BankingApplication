package com.banking;

import java.util.List;
import java.util.Objects;

public class Customer {

    private String name;
    private String surname;
    private List<Account> accountList;

    public Customer(String name, String surname, List<Account> accountList) {
        this.name = name;
        this.surname = surname;
        this.accountList = accountList;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(accountList, customer.accountList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, accountList);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
