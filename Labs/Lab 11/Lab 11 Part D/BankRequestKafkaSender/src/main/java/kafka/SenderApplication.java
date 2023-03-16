package kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SenderApplication implements CommandLineRunner {
    @Autowired
    Sender sender;



    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sender.send("create-account", new AccountRequestDTO(11112L,"Karna Shresthaa"));
        System.out.println("Account created message has been sent");

        sender.send("deposit-money",new TransactionRequestDTO(1263862L,3333.5));
        System.out.println("Deposit request message has been sent");

        sender.send("withdraw-money",new TransactionRequestDTO(1263862L,45.0));
        System.out.println("Withdraw request message has been sent");


    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
