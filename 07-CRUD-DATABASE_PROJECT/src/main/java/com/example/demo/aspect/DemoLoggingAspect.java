package com.example.demo.aspect;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	
	//setup logger
	Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	//setup pointcut declarations
	 @Pointcut("execution(* com.example.demo.controller.*.*(..))")
	 private void forControllerPackage() {}
	 
	 @Pointcut("execution(* com.example.demo.service.*.*(..))")
	 private void forServicePackage() {}
	 
	 @Pointcut("execution(* com.example.demo.dao.*.*(..))")
	 private void forDaoPackage() {}
	 
	 
	 
	 //combine pointcuts
	 @Pointcut("forControllerPackage()  || forServicePackage() || forDaoPackage()")
	 private void forAppFlow() {}

	 
	 //add Before advice
	 @Before("forAppFlow()")
	 public void before(JoinPoint theJoinPoint) {
		 
		 //display the method we are calling
		 String method = theJoinPoint.getSignature().toShortString();
		 myLogger.info("=====>>> in @Before: calling method: "+method);
		 
		 //display the arguments to the method 
		 Object[] args = theJoinPoint.getArgs();
		 
		 //loop through and display the args
		 for(Object temparg:args) {
			 myLogger.info("=====>>> argument: "+temparg);
		 }
	 }
	 
	 @AfterReturning(
			 pointcut="forAppFlow()",
			 returning = "theResult")
	 public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		 
		 //display method we are returning from
		 String method = theJoinPoint.getSignature().toShortString();
		 myLogger.info("=====>>> in @AfterReturning: from method: "+method);
		 
		 //display data returned
		 myLogger.info("=====>>> result: "+theResult); 
	 }
}
