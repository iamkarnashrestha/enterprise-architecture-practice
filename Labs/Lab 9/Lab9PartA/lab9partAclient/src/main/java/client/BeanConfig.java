package client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate RestTemplate(){
    RestTemplate restTemplate=new RestTemplate();
    return restTemplate;
    }
}

