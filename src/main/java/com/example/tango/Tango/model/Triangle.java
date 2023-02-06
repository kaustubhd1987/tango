package com.example.tango.Tango.model;

public class Triangle {

	public int calculate(Integer x, Integer y, Shape p) {
		
		if(p!=null) {
			return p.calculateArea(x, y);
		}
		return x-y;
	}
}
