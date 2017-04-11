package com.intellimed.aspect;

import org.aspectj.lang.JoinPoint;
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
	public void stringArgumentAdvice(String name){
		System.out.println("Invoked a method that takes a String argument. The provided value was " + name);

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
