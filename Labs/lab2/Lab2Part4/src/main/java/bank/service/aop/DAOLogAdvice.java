package bank.service.aop;

import bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class DAOLogAdvice {
    @Autowired
    Logger logger;
    @Before("execution(* bank.dao.*.*(..))")
    public void invoke(JoinPoint jp){
        logger.log("DAO Logging method "+jp.getSignature().getName());

    }
}
