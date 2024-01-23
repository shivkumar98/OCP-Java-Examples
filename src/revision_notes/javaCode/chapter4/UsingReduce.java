package revision_notes.javaCode.chapter4;

import java.util.stream.Stream;

public class UsingReduce {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("1", "23", "456");
		int i = stream.reduce(0,
				(Integer sum, String str)->{
					System.out.println("sum: "+sum);
					System.out.println("str: "+str);
					return sum+str.length();
				}, (Integer s1, Integer s2)->s1+s2);
		System.out.println(i);
		
		Stream<String> words = Stream.of("Hello","World","!");
		String concanatenatedWords = words.reduce(
				"", (String s1, String s2)->
				{
					System.out.println("s1: "+s1+ ", s2: "+s2);
					return s1+" "+s2;
				});
		System.out.println(concanatenatedWords);
	}
}
