package review_questions.chapter_9.attempt_2.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Q17 {
	public static void main(String[] args)  {
		try {
			Files.walk(Paths.get(".").toRealPath().getParent())
				.map(p -> p.toAbsolutePath().toString())
				.filter(s -> s.endsWith(".java"))
				.collect(Collectors.toList())
				.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
