package com.example.tango.Tango;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.tango.Tango.model.Shape;
import com.example.tango.Tango.model.Triangle;
import com.example.tango.Tango.service.MyThread;

@SpringBootTest
class TangoApplicationTests {

	//@Test
	void test1() {
		Thread t1 = new Thread(new MyThread());
    	t1.start();
    	Thread t2 = new Thread(new MyThread());
    	t2.start();
	}
	
	@Test
	void test2() {
		List<List<Integer>> nestedList = new ArrayList<>();
		nestedList.add(List.of(3, 6, 8));
		nestedList.add(List.of(1));
		nestedList.add(List.of(2, 7));
		List<Integer> flatList = nestedList.stream().flatMap(List::stream).toList();
		int sum = flatList.stream().reduce(1, Integer::sum);
		assertEquals(sum, 28);
	}
	
	@Test
	void test3() {

		Shape s = (x, y) -> x+y;
		int area = s.calculateArea(1, 2);
		Triangle t = new Triangle();
		int x1 = t.calculate(4, 2, s);
		int x2 = t.calculate(4, 2, null);
		System.out.println("x1: "+x1);
		System.out.println("x2: "+x2);
	}

}
