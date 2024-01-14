package com.mdbytes.aop;

import com.mdbytes.aop.dao.AccountDAO;
import com.mdbytes.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
      // read spring config
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

      // get the bean from spring container
      AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
      MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

      // call the business method
      accountDAO.addAccount();
      accountDAO.setName("pickles");
      System.out.println("AccountDAO Name: " + accountDAO.getName());
      accountDAO.setServiceCode("premier");
      System.out.println("AccountDAO ServiceCode: " + accountDAO.getServiceCode());
//      membershipDAO.addAccount();
//      membershipDAO.addSillyMember();
//      Account account = new Account();
//      accountDAO.addAccount(account);
//      accountDAO.addAccount(account,true);

      // close the context
      context.close();
    }
}
