package com.intellimed;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intellimed.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		shapeService.getCircle().setNameAndReturn("Dummy circle name");

		System.out.println(shapeService.getCircle().getName());
		//System.out.println(shapeService.getTriangle().getName());

	}

}
