package com.example.demo.aspect;


import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

//	//pointcut declaration
//	@Pointcut("execution(* com.example.demo.dao.*.*(..))")
//	private void forDaoPackage() {}
//	
//	//create a pointcut for getter methods
//	@Pointcut("execution(* com.example.demo.dao.*.get*(..))")
//	private void getter() {}
//	
//	//create a pointcut for setter methods
//	@Pointcut("execution(* com.example.demo.dao.*.set*(..))")
//	private void setter() {}
//	
//	//create pointcut: include package...exclude getter/setter
//	@Pointcut("forDaoPackage() && !(getter() || setter())")
//	private void forDaoPackageNoGetterSetter() {}
	
	@Around("execution(* com.example.demo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint)throws Throwable {
		 
		//print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @Around on Method: " + method);
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		//now,execute the method
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		}
		catch (Exception exc){
			System.out.println(exc.getMessage());
			
			result = "Major Accident! But no worries";
		}
		
		//get end timestamp
		long end = System.currentTimeMillis();
		//compute duration and display it
		long duration = end - begin;
		
		System.out.println("\n=======>>> Duration: "+duration/1000.0+" seconds");
		
		return result;
		
	}
	
	
	
	
	@After("execution(* com.example.demo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @After (finally) on Method: " + method);
	}
	
	
	@AfterThrowing(
			pointcut = "execution(* com.example.demo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @AfterThrowing on Method: " + method);
		
		//log the exception
		System.out.println("\n========>>> The exception is: "+theExc);
	}
	

	// Adding a new Advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.example.demo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @AfterReturning on Method: " + method);

		// print out the results of the method call
		System.out.println("\n========>>> result is: " + result);

		// let's post-process the data... let's modify it
		// convert the account names to Uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n========>>> result is: " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
	// TODO Auto-generated method stub
		for(Account tempAccount:result) {
			String uppercaseName = tempAccount.getName().toUpperCase();
			tempAccount.setName(uppercaseName);
		}
		
    }
	
	// To match on method in a package
	@Before("com.example.demo.aspect.AopPointcutExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		System.out.println("\n======>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("Method: " + methodSig);

		// display method arguments

		Object[] args = theJoinPoint.getArgs();

		for (Object temparg : args) {
			System.out.println(temparg);

			if (temparg instanceof Account) {

				// downcast and print Account specific stuff
				Account theAccount = (Account) temparg;

				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}

}
