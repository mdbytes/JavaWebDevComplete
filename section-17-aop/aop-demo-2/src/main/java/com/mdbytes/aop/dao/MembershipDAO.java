package com.mdbytes.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

  public void addAccount() {
    System.out.println(getClass() + ": Doing data stuff: Adding a Membership account");
  }

  public void addSillyMember() {
    System.out.println(getClass() + ": Doing data stuff: Adding silly member account");
  }
}
