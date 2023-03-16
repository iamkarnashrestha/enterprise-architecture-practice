package bank.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.Access;

@Component
public class TaxServiceJMSSenderImpl implements JMSSender{
    @Autowired
    JmsTemplate jmsTemplate;
    @Override
    public void sendJMSMessage(String text){
        jmsTemplate.convertAndSend("taxQueue",text);
    }
}
