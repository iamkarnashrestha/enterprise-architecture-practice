package jms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class TaxReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxReceiverApplication.class, args);
	}

}


