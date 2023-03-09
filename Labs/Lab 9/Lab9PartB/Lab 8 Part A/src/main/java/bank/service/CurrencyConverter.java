package bank.service;

import org.springframework.stereotype.Service;

@Service
public interface CurrencyConverter {
    public double euroToDollars (double amount);
    public double dollarsToEuros (double amount);
}
