package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
@EnableJms
public class SpringJmsCalculatorSenderApplication implements CommandLineRunner {
	@Autowired
	JmsTemplate jmsTemplate;


	public static void main(String[] args)  {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJmsCalculatorSenderApplication.class, args);
		context.close();
	}

	@Override
	public void run(String... args) throws Exception {


		Calculator calculator = new Calculator(5, '+');
		Calculator calculator1 = new Calculator(5, '*');
		Calculator calculator2 = new Calculator(5, '-');
		//convert calculator to JSON string
		ObjectMapper objectMapper = new ObjectMapper();
		String calculatorAsString = objectMapper.writeValueAsString(calculator);
		String calculatorAsString1 = objectMapper.writeValueAsString(calculator1);
		String calculatorAsString2 = objectMapper.writeValueAsString(calculator2);

		System.out.println("Sending a JMS message:" + calculatorAsString);
		jmsTemplate.convertAndSend("testCalculatorQueue",calculatorAsString);

		System.out.println("Sending a JMS message:" + calculatorAsString1);
		jmsTemplate.convertAndSend("testCalculatorQueue",calculatorAsString1);

		System.out.println("Sending a JMS message:" + calculatorAsString2);
		jmsTemplate.convertAndSend("testCalculatorQueue",calculatorAsString2);



	}

}
