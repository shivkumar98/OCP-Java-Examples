package revision_notes.javaCode.chapter4;

import java.util.stream.Stream;

public class IntermediateOperations {
	
	public static void main(String[] args) {
//		Stream<String> stream = Stream.of("z", "w", "y", "x");
//		stream
//			.peek(t -> System.out.println("peek: "+t))
//			.sorted()
//			.peek(t->System.out.println("after sort: "+t))
//			.forEach(s->{});
//		
		
		Stream<String> nums = Stream.of("y","xx","zzzz","www");
		nums.sorted((a,b)-> Integer.compare(a.length(), b.length()))
			.peek(t->System.out.println("peek: "+t))
			.allMatch(s->s.length()>0);					
	}
}
