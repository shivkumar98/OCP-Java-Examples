package revision_notes.javaCode.chapter4;

import java.util.function.Consumer;
import java.util.stream.Stream;


public class UsingForEach {

	static String printOddOrEven(int i) {
		System.out.println(i+" is "+(i%2==0?"even":"odd"));
		return (i%2==0?"even":"odd");
	}
	
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1,2,3,4,5);
		Consumer<Integer> c = i->printOddOrEven(i);
		stream.forEach(i->printOddOrEven(i));
		
	}
}
