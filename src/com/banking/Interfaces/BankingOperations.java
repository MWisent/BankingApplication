package com.banking.Interfaces;

import com.banking.Account;
import com.banking.enums.Currency;

public interface BankingOperations {

    /*
    * Wpłata określonej kwoty
    *
    * @param amount Kwota do wpłaty
    * @param currency Waluta, która robimy wypłaty
    * @return true jeśli operacja się powiedzie, false w przeciwnym razie
    */
    boolean deposit(double amount, Currency currency);

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
