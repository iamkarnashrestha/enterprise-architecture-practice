package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class LogAdvice {
    @After("execution(* customers.EmailSender.sendEmail(..)) && args(email,msg)")
    public void traceLog(JoinPoint joinpoint,String email,String msg) {
        EmailSenderImpl emailSender=(EmailSenderImpl)joinpoint.getTarget();
        System.out.println(LocalDateTime.now()+" method= "+joinpoint.getSignature().getName() +" address="+email);
        System.out.println("message= "+msg +" outgoing mail server= "+emailSender.getOutgoingMailServer());
    }
}
