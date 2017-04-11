package com.intellimed.model;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Setting the name of the circle!");
		// throw (new RuntimeException());
	}

	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("Setting the name of the circle!");
		return name;
	}

}
