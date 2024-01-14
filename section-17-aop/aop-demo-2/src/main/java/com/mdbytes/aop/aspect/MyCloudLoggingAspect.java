package com.mdbytes.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudLoggingAspect {


  // Pointcut declaration
  @Pointcut("execution(* com.mdbytes.aop.dao.*.*(..))")
  private void forDaoPackage() {}

  @Pointcut("execution(* com.mdbytes.aop.dao.*.get*(..))")
  private void getter(){}

  @Pointcut("execution(* com.mdbytes.aop.dao.*.set*(..))")
  private void setter(){}

  @Pointcut(value = "forDaoPackage() && !(getter() || setter())")
  private void forDAOPackageNoGetterSetter() {}

  @Before("forDAOPackageNoGetterSetter()")
  public void forDAONoGetterSetter() {
    System.out.println("\n===>>> Cloud Logging Aspect: Performing advice but not a get() or set() method");
  }
}
