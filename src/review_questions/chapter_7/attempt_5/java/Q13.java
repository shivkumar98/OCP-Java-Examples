package review_questions.chapter_7.attempt_5.java;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q13 {
	
	public static void main(String[] args) {
		Stream<String> cats = Stream.of("leopard","lynx","ocelot","puma").parallel();
		Stream<String> bears = Stream.of("panda","grizzly","polar").parallel();
		ConcurrentMap<Boolean, List<String>> data = Stream.of(cats,bears)
		  .flatMap(s -> s)
		  .collect(Collectors.groupingByConcurrent(s -> !s.startsWith("p")));
		System.out.println(data.get(false).size()+" "+data.get(true).size());
	}

}
