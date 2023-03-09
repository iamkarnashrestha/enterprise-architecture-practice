package bank.dto;

import bank.domain.AccountEntry;
import bank.domain.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDTO {
    private long accountnr;
    Collection<AccountEntryDTO> entryList = new ArrayList<AccountEntryDTO>();
    private CustomerDTO customer;

    public AccountDTO(long accountnr) {
        this.accountnr = accountnr;
    }
    public double getBalance() {
        double balance=0;
        for (AccountEntryDTO entry : entryList) {
            balance+=entry.getAmount();
        }
        return balance;
    }
    public long getAccountnr() {
        return accountnr;
    }

    public void setAccountnr(long accountnr) {
        this.accountnr = accountnr;
    }

    public Collection<AccountEntryDTO> getEntryList() {
        return entryList;
    }

    public void setEntryList(Collection<AccountEntryDTO> entryList) {
        this.entryList = entryList;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
