package kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Autowired
    private ObjectMapper objectMapper;

    public void send(String topic, AccountRequestDTO accountRequestDTO) throws JsonProcessingException {
        String accountMessage=objectMapper.writeValueAsString(accountRequestDTO);
        kafkaTemplate.send(topic, accountMessage);
    }

    public void  send(String topic,TransactionRequestDTO transactionRequestDTO) throws JsonProcessingException {
        String transasctionMessage=objectMapper.writeValueAsString(transactionRequestDTO);
        kafkaTemplate.send(topic,transasctionMessage);
    }



}
