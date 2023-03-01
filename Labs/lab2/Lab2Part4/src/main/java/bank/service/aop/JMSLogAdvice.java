package bank.service.aop;

import bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class JMSLogAdvice {
    @Autowired
    Logger logger;

    @After("execution(* bank.jms.JMSSender.*(..)) && args(message)")
    public void logJMSMessage(JoinPoint jp,String message){
        logger.log("JMS Logging "+ message);

    }
}
