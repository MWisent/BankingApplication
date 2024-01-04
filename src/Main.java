import com.banking.Account;
import com.banking.Customer;
import com.banking.enums.AccountStatus;
import com.banking.enums.AccountType;
import com.banking.enums.Currency;

import java.time.LocalDate;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // Utworzenie klienta
        Customer customer = new Customer(
                "Marcin", "Pełszyk", new ArrayList<>()
        );
        Customer customer2 = new Customer(
                "Viktoryia", "Pełszyk", new ArrayList<>()
        );
        // Utworzenie konta i dodanie do klienta
        Account account = new Account(
                "123456789", 0.0,
                customer, AccountStatus.ACTIVE,
                AccountType.SAVINGS, Currency.PLN, LocalDate.now(),
                new ArrayList<>()
        );
        Account account2 = new Account(
                "987654321", 0.0,
                customer, AccountStatus.ACTIVE,
                AccountType.SAVINGS, Currency.PLN, LocalDate.now(),
                new ArrayList<>()
        );
        customer.getAccountList().add(account);
        customer.getAccountList().add(account2);

        //Symulacja Operacji Bankowej
        account.deposit(1000.0, Currency.PLN);
        account.withdraw(250.0);
        account.deposit(2000.0, Currency.PLN);
        account2.deposit(1020.0, Currency.PLN);
        account2.withdraw(4000.0);
        account2.deposit(2200.0, Currency.PLN);
        // Symulacja transferu
        account.transfer(account2, 200.0);
        account2.transfer(account, 200.0);

        // Wyświetlenie informacji o koncie
        System.out.println("_________AC1_____________");
        System.out.println("Stan konta: " + account.getBalance() + " " + account.getCurrency());
        System.out.println("-------------------------");
        System.out.println("Historia tranzakcji: " + account.getTransactionHistory());
        System.out.println("!---------------------------------!");
        System.out.println("_________AC1_____________");
        System.out.println("Stan konta: " + account2.getBalance() + " " + account2.getCurrency());
        System.out.println("-------------------------");
        System.out.println("Historia tranzakcji: " + account2.getTransactionHistory());

    }
}