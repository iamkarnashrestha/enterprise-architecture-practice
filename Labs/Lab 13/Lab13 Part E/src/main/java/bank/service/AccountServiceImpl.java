package bank.service;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.dto.AccountAdapter;
import bank.dto.AccountDTO;
import bank.dto.AccountEntryAdapter;
import bank.dto.CustomerAdapter;
import bank.event.EmailEvent;
import bank.event.TraceRecordEvent;
import bank.jms.JMSSender;
import bank.logging.Logger;
import bank.repositories.AccountRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service

@Transactional
public class AccountServiceImpl implements AccountService {
	org.slf4j.Logger logger = LoggerFactory.getLogger(AccountService.class);
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CurrencyConverter currencyConverter;
	@Qualifier("taxServiceJMSSenderImpl")
	@Autowired
	private JMSSender jmsSender;
//	@Autowired
//	private Logger logger;
	@Autowired
	private ApplicationEventPublisher publisher;
	


	public AccountDTO createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountRepository.save(account);
		logger.info("createAccount with parameters accountNumber= "+accountNumber+" , customerName= "+customerName);

		return AccountAdapter.getAccountDTOFromAccount(account);
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber).get();
		account.deposit(amount);
		accountRepository.save(account);
		logger.info("deposit with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amount > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+amount+" to account with accountNumber= "+accountNumber);
		}
		publisher.publishEvent(new TraceRecordEvent(accountNumber,amount,"deposit operation"));
		publisher.publishEvent(new EmailEvent(accountNumber,amount,"deposit operation"));

	}

	public AccountDTO getAccount(long accountNumber) {
		Account account = accountRepository.findById(accountNumber).get();
		return AccountAdapter.getAccountDTOFromAccount(account);
	}

	public Collection<AccountDTO> getAllAccounts() {
		List<Account> accounts=accountRepository.findAll();
		List<AccountDTO> accountDTOS=new ArrayList<>();
		for(Account a:accounts){
			AccountDTO accountDTO = AccountAdapter.getAccountDTOFromAccount(a);
			accountDTO.setCustomer(CustomerAdapter.getCustomerDTOFromCustomer(a.getCustomer()));
			accountDTO.setEntryList(AccountEntryAdapter.getAccountEntryDTOsFromAccountEntrys((List<AccountEntry>) a.getEntryList()));
			accountDTOS.add(accountDTO);
		}
		return accountDTOS;
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber).get();
		account.withdraw(amount);
		accountRepository.save(account);
		logger.info("withdraw with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		publisher.publishEvent(new TraceRecordEvent(accountNumber,amount,"withdraw operation"));
		publisher.publishEvent(new EmailEvent(accountNumber,amount,"withdraw operation"));
	}

	public void depositEuros(long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber).get();
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.deposit(amountDollars);
		accountRepository.save(account);
		logger.info("depositEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amountDollars > 10000){
			jmsSender.sendJMSMessage("Deposit of  "+amount+" euros to account with accountNumber= "+accountNumber +" made");
		}
		publisher.publishEvent(new TraceRecordEvent(accountNumber,amount,"deposit euros operation"));
		publisher.publishEvent(new EmailEvent(accountNumber,amount,"deposit euros operation"));
	}

	public void withdrawEuros(long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber).get();
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.withdraw(amountDollars);
		accountRepository.save(account);
		logger.info("withdrawEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		publisher.publishEvent(new TraceRecordEvent(accountNumber,amount,"withdraw euros operation"));
		publisher.publishEvent(new EmailEvent(accountNumber,amount,"withdraw euros operation"));
	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountRepository.findById(fromAccountNumber).get();
		Account toAccount = accountRepository.findById(toAccountNumber).get();
		fromAccount.transferFunds(toAccount, amount, description);
		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);
		logger.info("transferFunds with parameters fromAccountNumber= "+fromAccountNumber+" , toAccountNumber= "+toAccountNumber+" , amount= "+amount+" , description= "+description);
		if (amount > 10000){
			jmsSender.sendJMSMessage("TransferFunds of $ "+amount+" from account with accountNumber= "+fromAccount+" to account with accountNumber= "+toAccount);
		}
	}
}
