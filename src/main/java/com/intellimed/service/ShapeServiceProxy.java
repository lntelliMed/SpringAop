package com.intellimed.service;

import com.intellimed.aspect.LoggingAspect;
import com.intellimed.model.Circle;

//This what Spring is actually doing behind the scenes when it comes to invoking the needed advice methods before/after the actual method calls, etc.
public class ShapeServiceProxy extends ShapeService {

	@Override
	public Circle getCircle() {
		new LoggingAspect().myAdvice();
		return super.getCircle();
	}

	
}
