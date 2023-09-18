package review_questions.chapter_5.attempt_1.javaCode;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Q16 {
	public static void main(String[] args) {
		String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
		String m2 = Duration.ofMinutes(1).toString();
		String s = Duration.of(60, ChronoUnit.SECONDS).toString();
		System.out.println(m1); // PT1M
		System.out.println(s); // PT1M
		System.out.println(Duration.ofMillis(1*1000*60)); // PT1M
		
		String d = Duration.ofDays(1).toString();
		String p = Period.ofDays(1).toString();
		System.out.println(d); // PT24H
		System.out.println(p); // P1D
	}
}
