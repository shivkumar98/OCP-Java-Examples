package chapter_4.c_4_2_workingWithBuiltInFunctionalInterfaces.java;

import java.util.*;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerInterface {
	
	public static void main(String[] args) {
		// a consumer accepts an argument and returns void
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = x -> System.out.println("here is x: "+ x);
		
		c1.accept("Shiv"); // Shiv
		c2.accept("Kumar"); // here is x: Kumar
		
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> b1 = (x,y)-> map.put(x, y) ;
		BiConsumer<String, Integer> b2 = map::put; // method ref works!
		//BiConsumer<Integer, String> b3 = map::put;
		
		b1.accept("Friends", 0);
		b1.accept("Chickens", 5);
		System.out.println(map); // {Friends=0, Chickens=5}
	}
	
	

}
