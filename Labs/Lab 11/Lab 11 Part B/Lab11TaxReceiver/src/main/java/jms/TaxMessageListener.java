package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TaxMessageListener {
 
    @JmsListener(destination = "taxQueue")
    public void receiveMessage(final String taxMessageString) {
        System.out.println(taxMessageString);

     }
}

