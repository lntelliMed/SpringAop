package com.intellimed.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
public class LoggingAspect {
	
	


	//@Before("allGetters()")
	@Before("allGetters() && allCircleMethods()")
	public void LoggingAdvice(){
		System.out.println("Advice is run. Invoking get method");
	}
	
	@Before("allGetters()")
	public void secondAdvice(){
		System.out.println("Second Advice is run");
	}
	
	//@Before("execution(public String com.intellimed.model.Circle.getName())")
	//@Before("execution(* get*())")
	//@Before("execution(* get*(*))")
	
	
	@Pointcut("execution(* get*(..))")
	public void allGetters() {}

	//@Pointcut("execution(* * com.intellimed.model.Circle.*(..))")
	@Pointcut("within(com.intellimed.model.Circle)")
	public void allCircleMethods() {}

}
