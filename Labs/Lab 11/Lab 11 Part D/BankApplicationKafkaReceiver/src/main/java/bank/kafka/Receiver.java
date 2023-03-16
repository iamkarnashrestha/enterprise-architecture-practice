package bank.kafka;

import bank.dto.AccountRequestDTO;
import bank.dto.TransactionRequestDTO;
import bank.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    @Autowired
    AccountService accountService;
@Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = {"create-account"})
    public void create(@Payload String message) throws JsonProcessingException {
        AccountRequestDTO accountRequestDTO=objectMapper.readValue(message,AccountRequestDTO.class);
        accountService.createAccount(accountRequestDTO.getAccountNumber(),accountRequestDTO.getName());
    }
    @KafkaListener(topics = {"deposit-money"})
    public void deposit(@Payload String message) throws JsonProcessingException {
        TransactionRequestDTO transactionRequestDTO=objectMapper.readValue(message, TransactionRequestDTO.class);
        accountService.deposit(transactionRequestDTO.getAccountNumber(), transactionRequestDTO.getAmount());
    }
    @KafkaListener(topics = {"withdraw-money"})
    public void withdraw(@Payload String message) throws JsonProcessingException {
        TransactionRequestDTO transactionRequestDTO=objectMapper.readValue(message, TransactionRequestDTO.class);
        accountService.withdraw(transactionRequestDTO.getAccountNumber(),transactionRequestDTO.getAmount());
    }
}
