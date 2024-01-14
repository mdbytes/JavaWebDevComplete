package com.mdbytes.aop.dao;

import com.mdbytes.aop.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

  private String name;

  private String serviceCode;
  public void addAccount() {
    System.out.println(getClass() + ": Doing my db work: Adding account.");
  }

  public void addAccount(Account account) {
    System.out.println(getClass() + ": Doing my db work: Adding account with account object.");
  }
  public void addAccount(Account account,boolean vipFlag) {
    System.out.println(getClass() + ": Doing my db work: Adding account account object and vipFlag.");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getServiceCode() {
    return serviceCode;
  }

  public void setServiceCode(String serviceCode) {
    this.serviceCode = serviceCode;
  }
}
