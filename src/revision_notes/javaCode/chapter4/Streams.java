package revision_notes.javaCode.chapter4;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Streams {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("chicken",34);
		
		Stream<Double> randoms = Stream.generate(()->Math.random());
		randoms.limit(6).peek(System.out::println).count();
		
		Stream<Integer> fibbonaci =
			Stream.iterate(0, i->i+2);
		fibbonaci
			.peek(System.out::println)
			.limit(7)
			.count();
	}
}
