package com.banking.Interfaces;

import com.banking.Account;

public interface BankingOperations {

    /*
    * Wpłata określonej kwoty
    *
    * @param amount Kwota do wpłaty
    * @return true jeśli operacja się powiedzie, false w przeciwnym razie
    */
    boolean deposit(double amount);

    /*
     * Wypłata określonej kwoty
     *
     * @param amount Kwota do wypłaty
     * @return true jeśli operacja się powiedzie, false w przeciwnym razie!
     */
    boolean withdraw(double amount);

    /*
     * Przelew z środków z tego konta na inne kontop.
     *
     * @param targetAccount Konto docelowe przelewu.
     * @param amount Kwota do wpłaty
     * @return true jeśli operacja się powiedzie, false w przeciwnym razie
     */

    boolean transfer(Account targetAccount, double amount);
}
