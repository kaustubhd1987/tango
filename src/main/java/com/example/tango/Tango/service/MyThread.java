package com.example.tango.Tango.service;

public class MyThread implements Runnable {

	@Override
	public void run() {
		try {
			MySingleton m = MySingleton.getInstance();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("created an instance");
	}

}
