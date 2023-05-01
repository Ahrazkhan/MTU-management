package ie.ahraz.MTUmanagement.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class Aspects {
    @Before("within(@org.springframework.web.bind.annotation.RestController *)")
     public void beforeRestControllerMethods(JoinPoint joinPoint) throws Throwable {
         log.error("/"+ joinPoint.getSignature().getName() + ": "+ Arrays.toString(joinPoint.getArgs()));
     }
}
