package com.mdbytes.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

  // Pointcut declaration
  @Pointcut("execution(* com.mdbytes.aop.dao.*.*(..))")
  private void forDaoPackage() {}

  @Pointcut("execution(* com.mdbytes.aop.dao.*.get*(..))")
  private void getter(){}

  @Pointcut("execution(* com.mdbytes.aop.dao.*.set*(..))")
  private void setter(){}

  @Pointcut(value = "forDaoPackage() && !(getter() || setter())")
  private void forDAOPackageNoGetterSetter() {}

  // @Before advice
  // matching on addAccount() from the Account class only
  @Before("forDaoPackage()")
  public void beforeAddAccountAdvice() {
    System.out.println("\n===>>> Logging Aspect: Executing @Before advice on anything in the dao package");
  }

}
