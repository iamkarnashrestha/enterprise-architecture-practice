package bank.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
@Aspect
@Configuration
public class StopWatchAdvice {
    @Around("execution(* bank.service.*.*(..))")
    public Object getRunTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch sw=new StopWatch();
        sw.start(proceedingJoinPoint.getSignature().getName());
        Object retVal=proceedingJoinPoint.proceed();
        sw.stop();
        long totalTime=sw.getLastTaskTimeMillis();
        System.out.println("Runtime of "+proceedingJoinPoint.getSignature().getName()+":" +totalTime+" ms");
        return retVal;

    }
}
