package chapter_3.chapter_3_5_additions_in_java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEach {
	
	public static void main(String[] args) {
		List<String> list =  Arrays.asList("Shiv", "Sammy", "Rohan", "Rikesh");
		list.forEach(System.out::println); // Shiv   Sammy   Rohan  	Rikesh
	}
}
