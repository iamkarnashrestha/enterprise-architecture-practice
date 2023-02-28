package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

//
//    @Bean
//    public CustomerService customerService(){
//        CustomerService customerService = new CustomerService();
//        customerService.setEmailSender(emailSender());
//        customerService.setCustomerDAO(customerDAO());
//        return customerService;
//    }
//
//    @Bean
//    public EmailSender emailSender(){
//        return new EmailSender(logger());
//    }
//
//    @Bean
//    public CustomerDAO customerDAO(){
//        return new CustomerDAO(logger());
//    }
//    @Bean
//    public  Logger logger(){
//        return new Logger();
//    }
}
