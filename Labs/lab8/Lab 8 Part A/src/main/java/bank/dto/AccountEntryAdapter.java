package bank.dto;

import bank.domain.AccountEntry;

import java.util.ArrayList;
import java.util.List;

public class AccountEntryAdapter {
    public static AccountEntry getAccountEntryFromAccountEntryDTO(AccountEntryDTO accountEntryDTO){
        return new AccountEntry(accountEntryDTO.getDate(),accountEntryDTO.getAmount(),accountEntryDTO.getDescription(),accountEntryDTO.getFromAccountNumber()
                ,accountEntryDTO.getFromPersonName()
        );
    }
    public static AccountEntryDTO getAccountEntryDTOFromAccountEntry(AccountEntry accountEntry){
        return new AccountEntryDTO(accountEntry.getDate(), accountEntry.getAmount(),accountEntry.getDescription(),
                accountEntry.getFromAccountNumber(), accountEntry.getFromPersonName());
    }
    public static List<AccountEntryDTO> getAccountEntryDTOsFromAccountEntrys(List<AccountEntry> accountEntrys){
        List<AccountEntryDTO> accountEntryDTOs = new ArrayList<AccountEntryDTO>();
        for (AccountEntry accountEntry: accountEntrys){
            accountEntryDTOs.add(getAccountEntryDTOFromAccountEntry(accountEntry));
        }
        return accountEntryDTOs;
    }
}
