package com.mdbytes.aop;

import com.mdbytes.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.mdbytes.aop")
public class DemoConfig {




}
