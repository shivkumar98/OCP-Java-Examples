package chapter_4.c_4_6_working_advanced_stream_pipeline_concepts.java;

import java.util.Optional;

public class ChainingOptionals {
	
	public static void main(String[] args) {
		Optional<String> optional = Optional.of("Shiv");
		// we map the to lengths:
		Optional<Integer> result = optional.map(String::length);
		// can we map using a function which returns Optional?
		// Optional<Integer> result2 = optional.map(ChainingOptionals::calculator); 
		// ^^ DOES NOT COMPILE
		// We can write:
		Optional<Optional<Integer>> result2 = optional.map(ChainingOptionals::calculator);
	}
	
	static Optional<Integer> calculator(String s){
		return Optional.of(1);
	}

}
