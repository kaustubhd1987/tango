package com.example.tango.Tango.service;

public class MySingleton {

	private static MySingleton instance = null;
	private static int count = 0;
	
	private MySingleton() {
		
	}
	
	public static MySingleton getInstance() throws InterruptedException {
		if(instance == null) {
			 count++;
			 System.out.println("should be called once only. this is instance no: " + count);
			 Thread.sleep(3000);
			 instance = new MySingleton();
		}
		return instance;
	}
}
