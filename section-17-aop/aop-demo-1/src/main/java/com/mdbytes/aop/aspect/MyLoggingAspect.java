package com.mdbytes.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

  // @Before advice

  // matching on addAccount() from the Account class only
  @Before("execution(public void com.mdbytes.aop.dao.AccountDAO.addAccount())")
  public void beforeAddAccountAdvice() {
    System.out.println("\n===>>> Executing @Before advice on addAccount()");
  }

  // matching on addAccount(Account) from the Account class only
  @Before("execution(public void com.mdbytes.aop.dao.AccountDAO.addAccount(com.mdbytes.aop.Account))")
  public void beforeAddAccountWithAccountAdvice() {
    System.out.println("\n===>>> Executing @Before advice on addAccount(Account)");
  }

  // matching on addAccount(Account,...) from the Account class only
  @Before("execution(public void com.mdbytes.aop.dao.AccountDAO.addAccount(com.mdbytes.aop.Account...))")
  public void beforeAddAccountWithAccountAndVipFlagAdvice() {
    System.out.println("\n===>>> Executing @Before advice on addAccount(Account...)");
  }

  @Before("execution(public void add*())")
  public void beforeAddAdvice() {
    System.out.println("\n===>>> Executing @Before advice on add*()");
  }

  // Modifier can be omitted
  @Before("execution(void add*())")
  public void beforeAddAnyAdvice() {
    System.out.println("\n===>>> Executing @Before advice on add*() without modifier");
  }

}
