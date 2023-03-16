package bank.controllers;

import bank.dto.AccountDTO;
import bank.dto.AccountRequestDTO;
import bank.dto.TransactionRequestDTO;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public ResponseEntity<?> getAllAccounts() {
        return new ResponseEntity<Collection<AccountDTO>>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @PostMapping("/accounts")
    public ResponseEntity<?> createAccount(@RequestBody AccountRequestDTO accountRequestDTO){

        accountService.createAccount(accountRequestDTO.getAccountNumber(), accountRequestDTO.getName());
        return new ResponseEntity<String>("Account with Customer name "+accountRequestDTO.getName()+" and account number: "+accountRequestDTO.getAccountNumber()+ " created successfully.",HttpStatus.OK);

    }


    @PostMapping("accounts/{accountnumber}/deposit")
    public ResponseEntity<?> deposit(@PathVariable Long accountnumber, @RequestBody TransactionRequestDTO requestDTO) {
        accountService.deposit(accountnumber, requestDTO.getAmount());
        String response = "Amount " + requestDTO.getAmount() + " is successfully deposited to account number " + accountnumber;
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


    @PostMapping("accounts/{accountnumber}/withdraw")
    public ResponseEntity<?> withdraw(@PathVariable Long accountnumber, @RequestBody TransactionRequestDTO requestDTO)
        {
            accountService.withdraw(accountnumber,requestDTO.getAmount());
            String response="Amount "+ requestDTO.getAmount()+" is successfully withdrawn from account number "+ accountnumber;
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }

    @PostMapping("accounts/{accountnumber}/depositeuros")
    public ResponseEntity<?> depositeuros(@PathVariable Long accountnumber, @RequestBody TransactionRequestDTO requestDTO)
    {
        accountService.depositEuros(accountnumber,requestDTO.getAmount());
        String response = "Amount " + requestDTO.getAmount() + "euros is successfully deposited to account number " + accountnumber;
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PostMapping("accounts/{accountnumber}/withdraweuros")
    public ResponseEntity<?> withdraweuros(@PathVariable Long accountnumber, @RequestBody TransactionRequestDTO requestDTO)
    {
        accountService.withdrawEuros(accountnumber,requestDTO.getAmount());
        String response = "Amount " + requestDTO.getAmount() + " euros is successfully withdrawn from account number " + accountnumber;
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PostMapping("accounts/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransactionRequestDTO requestDTO)
    {
        accountService.transferFunds(requestDTO.getFromAccountNumber(),
                requestDTO.getToAccountNumber(),
                requestDTO.getAmount(),
                requestDTO.getDescription());
        String response = "Amount " + requestDTO.getAmount() + " is successfully transferred from account number: " + requestDTO.getFromAccountNumber()+ " to account number: "+requestDTO.getToAccountNumber();
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }




}
