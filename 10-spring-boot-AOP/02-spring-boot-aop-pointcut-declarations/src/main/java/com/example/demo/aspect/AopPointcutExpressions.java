package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointcutExpressions {

	// pointcut declaration
	@Pointcut("execution(* com.example.demo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// create a pointcut for getter methods
	@Pointcut("execution(* com.example.demo.dao.*.get*(..))")
	public void getter() {
	}

	// create a pointcut for setter methods
	@Pointcut("execution(* com.example.demo.dao.*.set*(..))")
	public void setter() {
	}

	// create pointcut: include package...exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}
}
