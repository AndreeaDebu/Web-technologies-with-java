package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    @Around("execution(* service.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info("Before executing!");

        System.out.println("Method " + joinPoint.getSignature().getName() +
                " from " + joinPoint.getTarget().getClass() +
                " whit args " + Arrays.asList(joinPoint.getArgs()) +
                " will be executed. Timestamp: " + LocalDateTime.now());

        joinPoint.proceed();

        System.out.println("Method " + joinPoint.getSignature().getName() +
                " from " + joinPoint.getTarget().getClass() +
                " whit args " +  Arrays.asList(joinPoint.getArgs()) +
                " finished the execution. Timestamp: " + LocalDateTime.now());

        logger.info("After executing!");


    }

}