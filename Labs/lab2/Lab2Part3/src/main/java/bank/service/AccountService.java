package bank.service;

import bank.domain.Account;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service

public interface AccountService {
    public Account createAccount(long accountNumber, String customerName);
    public Account getAccount(long accountNumber);
    public Collection<Account> getAllAccounts();
    public void deposit (long accountNumber, double amount);
    public void withdraw (long accountNumber, double amount);
    public void depositEuros (long accountNumber, double amount);
    public void withdrawEuros (long accountNumber, double amount);
    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
}
