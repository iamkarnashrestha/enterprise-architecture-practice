package bank.dto;

import bank.domain.Account;
import bank.domain.AccountEntry;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter {
    public static Account getAccountFromAccountDTO(AccountDTO accountDTO){
        return new Account(accountDTO.getAccountnr()
               );
    }
    public static AccountDTO getAccountDTOFromAccount(Account account){
        return new AccountDTO(account.getAccountnumber());
    }
    public static List<AccountDTO> getAccountDTOsFromAccounts(List<Account> accounts){
        List<AccountDTO> accountDTOs = new ArrayList<AccountDTO>();
        for (Account account: accounts){
            accountDTOs.add(getAccountDTOFromAccount(account));
        }
        return accountDTOs;
    }

}
