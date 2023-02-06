package com.example.tango.Tango.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleThread implements Runnable{

	@Override
	public void run() {
		Map<String,Integer> marksMap = new HashMap<>();
		List<String> resp = marksMap.entrySet().stream()
		.sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
		.map(e -> e.getKey())
		.toList();
		
	}
}
