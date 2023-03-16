package accounts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository repository;
		
	public AccountDTO getAccount(String acountNumber) {
		Optional<Account> accountOptional = repository.findById(acountNumber);
		if (accountOptional.isPresent()) {
			Account account = accountOptional.get();
			AccountDTO accountDto = AccountAdapter.getAccountDto(account);
			return accountDto;
		}
		return null;
	}
	
	public Account createAccount(String accountNumber, double amount, String accountHolder) {
		return repository.save(new Account(accountNumber, amount, accountHolder));
	}
	

}
