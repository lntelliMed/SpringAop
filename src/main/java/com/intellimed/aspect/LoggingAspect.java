package com.intellimed.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.intellimed.model.Circle;

@Aspect
public class LoggingAspect {
	
	


	//@Before("allGetters()")
	@Before("allGetters() && allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint){
		//Circle circle = (Circle) joinPoint.getTarget();
		System.out.println("Advice is run. Invoking the method " + joinPoint.toString() + " on the object " + joinPoint.getTarget());
	}
	
	@Before("allGetters()")
	public void secondAdvice(){
		System.out.println("Second Advice is run");
	}
	
	@Before("args(name)")
	public void stringArgumentBeforeAdvice(String name){
		System.out.println("Before invoking a method that takes a String argument. The provided value was " + name);

	}
	
	@After("args(name)") // Regardless if an exception was thrown or not
	public void stringArgumentAfterAdvice(String name){
		System.out.println("After invoking a method that takes a String argument. The provided value was " + name);

	}
	
	@AfterReturning(pointcut="args(name)", returning="returnedString") // Only if method returned successfully (no exception was thrown)
	public void stringArgumentAfterReturnAdvice(String name, Object returnedString){
		System.out.println("After invoking a method that takes a String argument. The provided value was " + name + ". The returned value was " + returnedString);

	}
	
	@AfterThrowing(pointcut="args(name)", throwing="ex") // After throwing an exception
	public void stringArgumentAfterThrowAdvice(String name, Exception ex){
		System.out.println("Exception was thrown! " + ex);

	}
	
	
	//@Around("allGetters()")
	@Around("@annotation(com.intellimed.aspect.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		
		Object returnedObject = null;
		
		try {
			System.out.println("Around - Before..");
			returnedObject = proceedingJoinPoint.proceed();
			System.out.println("Around - After returning..");

		} catch (Throwable e) {
			System.out.println("Around - After throwing..");

		}
		
		System.out.println("Around - After finally..");
		return returnedObject;
	}
	
	
	
	
	//@Before("execution(public String com.intellimed.model.Circle.getName())")
	//@Before("execution(* get*())")
	//@Before("execution(* get*(*))")
	
	
	@Pointcut("execution(* get*(..))")
	public void allGetters() {}

	//@Pointcut("execution(* * com.intellimed.model.Circle.*(..))")
	@Pointcut("within(com.intellimed.model.Circle)")
	public void allCircleMethods() {}
	
	@Pointcut("execution(* com.intellimed.service.*Service.*(..))")
	public void allServiceMethods(){}

	public void myAdvice(){
		System.out.println("Calling the advice manually through a proxy object and not via Spring!");
	}
}
