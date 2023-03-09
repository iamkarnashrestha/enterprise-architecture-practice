package bank.service;

import bank.domain.Account;
import bank.domain.Customer;
import bank.domain.TraceRecord;
import bank.integration.EmailSender;
import bank.repositories.AccountRepository;
import bank.repositories.CustomerRepository;
import bank.repositories.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class BankService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private TraceRecordRepository traceRecordRepository;
	
	@Transactional
	public void createCustomerAndAccount(int customerId, String customerName, String emailAddress, String AccountNumber){
		try {
			Account account = new Account(AccountNumber);
			accountRepository.save(account);
			Customer customer = new Customer(customerId, customerName);
			customer.setAccount(account);
			customerRepository.saveCustomer(customer);
			emailSender.sendEmail(emailAddress, "Welcome "+customerName);
			traceRecordRepository.save(new TraceRecord(LocalDate.now(), LocalTime.now(),"Customer "+ customerName +" created with account "+AccountNumber));
		}
		catch(RuntimeException re)
		{

			traceRecordRepository.save(new TraceRecord(LocalDate.now(), LocalTime.now(),"Could not create customer "+ customerName +" created with account "+AccountNumber));
			emailSender.sendEmail(emailAddress, "We could not create your account "+AccountNumber);
			throw re;
		}

	}

}
