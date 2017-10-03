package aop.aspectJ;

// AOP 切面

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 使用aspectj 表达式来定义切面
 * 环绕通知
 */
@Aspect
public class AudienceAround {

    // 切点
    @Pointcut("execution(* aop.aspectJ.Performance.perform(..))")
    public void performance() {}

    // 环绕通知
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Around! silence Cell Phones");
        jp.proceed();
        System.out.println("Around! CLAP CLAP!!");

    }
}