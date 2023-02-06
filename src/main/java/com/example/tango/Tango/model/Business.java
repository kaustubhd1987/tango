package com.example.tango.Tango.model;

public class Business {

	private String name;
	private String desc;

	public Business(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
