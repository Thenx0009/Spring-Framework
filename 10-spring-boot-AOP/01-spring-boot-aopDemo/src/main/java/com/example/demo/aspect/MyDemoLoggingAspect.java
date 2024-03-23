package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect	
@Component
public class MyDemoLoggingAspect {

	//@Before("execution(public void addAccount())")
	
	//match method to a specific class
	//@Before("execution(public void com.example.demo.dao.AccountDAOImpl.addAccount())")
	
	//match method using wildcard(*)
	//@Before("execution(public void add*())")
	
	//match method on the basis on Return type
	//@Before("execution(void add*())")
	//@Before("execution(* add*())")
	
	//passing the parameter od Account class
	//@Before("execution(* add*(com.example.demo.Account))")
	
	//to handle the more params
	//@Before("execution(* add*(com.example.demo.Account, ..))")
	
	//To match with any params
	//@Before("execution(* com.example..add*(..))")
	
	//To match on method in a package
	@Before("execution(* com.example.demo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n======>>> Executing @Before advice on method");
	}
}
