package aop.aspectJ;

// AOP 切面

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 使用aspectj 表达式来定义切面等。
 */
@Aspect
public class Audience {

    // 切点
    @Pointcut("execution(* aop.aspectJ.Performance.perform(..))")
    public void performance() {}

    // 前置通知
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("silence Cell Phones");
    }

    // 后置通知
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP!!");
    }
}